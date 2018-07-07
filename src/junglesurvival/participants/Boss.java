package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public abstract class Boss extends Enemy {

    protected Boss(String name, int lifePoints, int attack, int givenExperience) throws InvalidNameException {
        super(name, lifePoints, attack, givenExperience);
    }

    abstract void specialAttack();
}
