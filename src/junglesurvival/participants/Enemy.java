package junglesurvival.participants;

import junglesurvival.exceptions.InvalidNameException;

public abstract class Enemy extends Participant {

    private int givenExperience;

    protected Enemy(String name, int lifepoints, int attack, int givenExperience) throws InvalidNameException {
        super(name, lifepoints, attack);
        setGivenExperience(givenExperience);
    }

    public int getGivenExperience() {
        return givenExperience;
    }

    private void setGivenExperience(int givenExperience) {
        this.givenExperience = givenExperience;
    }

    public abstract void attack(Hero hero);
}
