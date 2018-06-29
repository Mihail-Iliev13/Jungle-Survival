package junglesurvival.participants;

public abstract class Boss extends Enemy {

    public Boss(String name) {
        super(name);
    }

    abstract void specialAttack();
}
