package junglesurvival.participants;

public class Participant {
    private String name;
    private int lifepoints;
    private int attack;


    protected Participant(String name) {
        setName(name);
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

    private void setName(String name){

        if(name.length() < 2 || name.length() > 25) {
            System.out.println("Invalid Name"); //TODO: it would be better if the method throws exception
        } else {
        this.name = name;
        }
    }
}