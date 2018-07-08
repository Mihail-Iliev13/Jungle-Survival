package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.exceptions.InvalidNameException;

public class LordOfTheFlies extends Boss implements Flyable {

    private static final int LORD_LIFE_POINTS = 70;
    private static final int LORD_ATTACK_POINTS = 12;
    private static final int SPECIAL_BONUS = 7;
    private static final int GIVEN_EXPERIENCE = 75;


    public LordOfTheFlies() throws InvalidNameException {
        super("Lord of the Flies", LORD_LIFE_POINTS, LORD_ATTACK_POINTS, GIVEN_EXPERIENCE);
    }

    @Override
    void specialAbility() {
        System.out.println("Vampiric Attack!\n Lord is healing!");
        setLifepoints(getLifepoints() + SPECIAL_BONUS);
    }

    @Override
    public void attack(Hero hero) {
        Dice dice = new Dice();
        int diceValue = dice.getValue() + dice.getValue();
        int attack = this.getAttack();

        hero.setLifepoints(hero.getLifepoints() - attack);

        if(diceValue >= 7) {
            specialAbility();
            hero.setLifepoints(hero.getLifepoints() - SPECIAL_BONUS);
        }
    }

    @Override
    public void fly() {
        System.out.printf("The %s can fly! Do you have range weapon?\n", this.getName());
    }
}
