package junglesurvival.participants;

import junglesurvival.exceptions.InvalidNameException;

public abstract class Boss extends Enemy {

    protected Boss(String name, int lifePoints, int attack, int givenExperience) throws InvalidNameException {
        super(name, lifePoints, attack, givenExperience);
    }

    abstract void specialAbility();
}
