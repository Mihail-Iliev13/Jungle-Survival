package junglesurvival.participants;

public class Participant {
    private String name;
    private int lifepoints;
    private int attack;


    protected Participant(String name) {
        this.name = name;
    }

    public int getLifepoints() {
        return lifepoints;
    }

    protected void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    protected int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }
}