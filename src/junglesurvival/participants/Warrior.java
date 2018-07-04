package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.Exceptions.InvalidNameException;
import junglesurvival.items.Item;
import junglesurvival.items.Weapon;
import junglesurvival.items.WeaponType;

public class Warrior extends Hero{

    private static final int WARRIOR_LIFE_POINTS = 200;
    private static final int WARRIOR_ATTACK_POINTS = 10;
    private static final int SPECIAL_ATTACK_BONUS = 5;

    private static final int MAX_ATTACK_FROM_ITEMS=45;

    public Warrior(String name) throws InvalidNameException {

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
            if(getBag().stream().filter(s->s instanceof Weapon).anyMatch(s->((Weapon) s).getType().equals(WeaponType.RANGE)))
                finalAttack=getAttack();
            else
                finalAttack=getAttack()/2;
        }

//            for (Item item : getBag()) { //todo Can we streamAPI this?
//                if (item instanceof Weapon) {
//                    if (((Weapon) item).getType().equals(WeaponType.RANGE)) {
//                        finalAttack = getAttack();
//                        break;
//                    }
//                }
//            }
//            if(finalAttack==0)
//                finalAttack=getAttack()/2;
//        }
        else
            finalAttack=getAttack();


        if (diceValue > 4) {
            if (diceValue == 6) {
                finalAttack = (finalAttack * 2) + SPECIAL_ATTACK_BONUS;
                System.out.println("In an adrenaline rush you swung your weapon really hard and dealt a lot of damage!");
            }

            else {
                finalAttack += SPECIAL_ATTACK_BONUS;
                System.out.println("You've hit a vital spot on your enemy and dealt more damage.");
            }
        }


        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);
        System.out.println("You've attacked for "+finalAttack+" damage.");

        if (enemy.getLifepoints() <= 0)
            setExperience(enemy.getGivenExperience());
    }
}
