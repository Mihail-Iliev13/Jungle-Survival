package junglesurvival.participants;

import junglesurvival.Dice;

public class AngrySlicer extends Boss {

    private static final int SLICER_LIFE_POINTS= 85;
    private static final int SLICER_ATTACK_POINTS = 9;
    private static final int GIVEN_EXPERIENCE = 75;

    public AngrySlicer() {
        super("Angry Slicer");
        setLifepoints(SLICER_LIFE_POINTS);
        setAttack(SLICER_ATTACK_POINTS);
        setGivenExperience(GIVEN_EXPERIENCE);
    }

    @Override
    void specialAttack() {
        Dice dice = new Dice();
        int diceValue = dice.getValue();
        System.out.println("Careful! Angry Slicer Attack is increasing!");
        setAttack(getAttack() + diceValue);
    }

    @Override
    public void attack(Hero hero) {
        int finalAttack = this.getAttack();
        hero.setLifepoints(hero.getLifepoints() - finalAttack);
        specialAttack();
    }
}
