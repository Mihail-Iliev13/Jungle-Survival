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
}
