package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.items.Item;
import junglesurvival.items.Weapon;
import junglesurvival.items.WeaponType;

public class Warrior extends Hero {

    private static final int WARRIOR_LIFE_POINTS = 200;
    private static final int WARRIOR_ATTACK_POINTS = 20;
    private static final int SPECIAL_ATTACK_BONUS = 5;

    public Warrior(String name) {

        super(name);
        setLifepoints(WARRIOR_LIFE_POINTS);
        setAttack(WARRIOR_ATTACK_POINTS);
        setGender(Gender.MALE);

    }

    @Override
    public void attackEnemy(Enemy enemy) {
        Dice dice = new Dice();
        int diceValue = dice.getValue();
        int finalAttack = 0;
        if (enemy instanceof Flyable) {
            for (Item item : getBag()) { //todo Can we streamAPI this?
                if (item instanceof Weapon) {
                    if (((Weapon) item).getType().equals(WeaponType.RANGE)) {
                        finalAttack = getAttack();
                        break;
                    }
                }
            }
            if(finalAttack==0)
                finalAttack=getAttack()/2;
        }
        else
            finalAttack=getAttack();


        if (diceValue > 4) {
            if (diceValue == 6)
                finalAttack = (finalAttack * 2) + SPECIAL_ATTACK_BONUS;
            else
                finalAttack += SPECIAL_ATTACK_BONUS;
        }


        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);

        if (enemy.getLifepoints() <= 0) setExperience(enemy.getGivenExperience());
    }
}
