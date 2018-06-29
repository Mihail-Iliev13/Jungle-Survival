package junglesurvival.participants;

import junglesurvival.Dice;

public class LordOfTheFlies extends Boss implements Flyable {

    private static final int LORD_LIFE_POINTS = 70;
    private static final int LORD_ATTACK_POINTS = 10;
    private static final int SPECIAL_BONUS = 7;
    private static final int GIVEN_EXPERIENCE = 75;


    public LordOfTheFlies() {
        super("Lord of the Flies");
        setLifepoints(LORD_LIFE_POINTS);
        setAttack(LORD_ATTACK_POINTS);
        setGivenExperience(GIVEN_EXPERIENCE);
    }

    @Override
    void specialAttack() {
        System.out.println("Vampiric Attack!\n Lord is healing!");
        setLifepoints(getLifepoints() + SPECIAL_BONUS);

    }

    @Override
    public void attack(Hero hero) {
        Dice dice = new Dice();
        int diceValue = dice.getValue() + dice.getValue();
        int finalAttack = this.getAttack();

        hero.setLifepoints(hero.getLifepoints() - finalAttack);

        if(diceValue >= 9) {
            hero.setLifepoints(hero.getLifepoints() - SPECIAL_BONUS);
            specialAttack();
        }
    }

    @Override
    public void fly() {
        System.out.printf("The %s can fly! Do you have range weapon?", this.getName());
    }
}