package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.Exceptions.InvalidNameException;
import junglesurvival.items.Item;
import junglesurvival.items.Weapon;
import junglesurvival.items.WeaponType;

public class Amazon extends Hero {

    private static final int AMAZON_LIFE_POINTS = 150;
    private static final int AMAZON_ATTACK_POINTS = 8;
    private static final int SPECIAL_ATTACK_BONUS = 6;

    public Amazon(String name) throws InvalidNameException {
        super(name, AMAZON_LIFE_POINTS, AMAZON_ATTACK_POINTS, Gender.FEMALE);
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

        if (diceValue > 3) {
            if (diceValue == 6) {
                finalAttack = finalAttack + (SPECIAL_ATTACK_BONUS * 2);
                System.out.println("With your amazon power, you swung your weapon " +
                        "and cut off your enemy's limb, thus dealing lots of damage!");
            } else {
                finalAttack += SPECIAL_ATTACK_BONUS;
                System.out.println("You've hit a vital spot on your enemy and dealt more damage.");
            }
        }

        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);
        System.out.println("You've attacked for " + finalAttack + " damage.");

        if (enemy.getLifepoints() <= 0){
          setExperience(enemy.getGivenExperience());
        }
    }
}
