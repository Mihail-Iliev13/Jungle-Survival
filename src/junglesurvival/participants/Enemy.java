package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public abstract class Enemy extends Participant {

    private int givenExperience;

    public Enemy(String name) throws InvalidNameException {
        super(name);
    }

    public int getGivenExperience() {
        return givenExperience;
    }

    protected void setGivenExperience(int givenExperience) {
        this.givenExperience = givenExperience;
    }

    public abstract void attack(Hero hero);
}
