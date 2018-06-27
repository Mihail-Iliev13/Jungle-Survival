package junglesurvival.participants;

public abstract class Enemy extends Participant {
    public int givenExperience;

    public Enemy(String name, int lifepoints, int attack) {
        super(name, lifepoints, attack);
    }

    public abstract void attack(Hero hero);
}
