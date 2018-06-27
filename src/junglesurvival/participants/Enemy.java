package junglesurvival.participants;

public abstract class Enemy extends Participant {
    public int givenExperience;

    public Enemy(String name, int lifepoints, int attack, int givenExperience) {
        super(name, lifepoints, attack);
        this.givenExperience = givenExperience;
    }

    public abstract void attack(Hero hero);
}
