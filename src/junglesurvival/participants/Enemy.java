package junglesurvival.participants;

public abstract class Enemy extends Participant {
    public int givenExperience;

    Enemy(String name, int lifePoints, int attack, int givenExperience) {
        super(name, lifePoints, attack);
        this.givenExperience = givenExperience;
    }


    public abstract void attack(Hero hero);
}
