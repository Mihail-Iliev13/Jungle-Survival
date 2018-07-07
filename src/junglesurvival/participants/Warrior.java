package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.Exceptions.InvalidNameException;
import junglesurvival.items.Item;
import junglesurvival.items.Weapon;
import junglesurvival.items.WeaponType;

public class Warrior extends Hero {

    private static final int WARRIOR_LIFE_POINTS = 200;
    private static final int WARRIOR_ATTACK_POINTS = 10;
    private static final int SPECIAL_ATTACK_BONUS = 5;

    public Warrior(String name) throws InvalidNameException {
        super(name, WARRIOR_LIFE_POINTS, WARRIOR_ATTACK_POINTS, Gender.MALE);
    }

    @Override
    public void attackEnemy(Enemy enemy) {

        Dice dice = new Dice();
        int diceValue = dice.getValue();
        int finalAttack;

        if (!hasRangeWeapn() && enemy instanceof Flyable) {
            finalAttack = getAttack() / 2;
        } else {
            finalAttack = getAttack();
        }

        if (diceValue > 4) {
            if (diceValue == 6) {
                finalAttack = (finalAttack * 2) + SPECIAL_ATTACK_BONUS;
                System.out.println("In an adrenaline rush you swung your weapon really hard and dealt a lot of damage!");
            } else {
                finalAttack += SPECIAL_ATTACK_BONUS;
                System.out.println("You've hit a vital spot on your enemy and dealt more damage.");
            }
        }


        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);
        System.out.println("You've attacked for " + finalAttack + " damage.");

        if (enemy.getLifepoints() <= 0)
            setExperience(enemy.getGivenExperience());
    }
}
