package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public abstract class Boss extends Enemy {

    public Boss(String name) throws InvalidNameException {
        super(name);
    }

    abstract void specialAttack();
}
