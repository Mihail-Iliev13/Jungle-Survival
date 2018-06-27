package junglesurvival.participants;

public class Participant {
    private String name;
    private  int lifepoints;
    private  int attack;


    public Participant(String name, int lifepoints, int attack) {
        this.name = name;
        this.lifepoints = lifepoints;
        this.attack = attack;
    }

    public int getLifepoints() {
        return lifepoints;
    }

    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    int getAttack() {
        return attack;
    }

    void setAttack(int attack) {
        this.attack = attack;
    }

    String getName() {
        return name;
    }
}
