package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public class Participant {
    private String name;
    private int lifepoints;
    private int attack;
    private static final int MIN_NAME_LENGHT = 2;
    private static final int MAX_NAME_LENGHT = 25;

    protected Participant(String name) throws InvalidNameException {
        setName(name);
    }

    public int getLifepoints() {
        return lifepoints;
    }

    protected void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    public int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidNameException {

        if(name.length() < MIN_NAME_LENGHT || name.length() > MAX_NAME_LENGHT||!Character.isUpperCase(name.charAt(0))) {
//            System.out.println("Invalid Name"); //TODO: it would be better if the method throws exception
            throw new InvalidNameException();
        } else {
        this.name = name;
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nRemaining LifePoints: %d\nAttacking power: %d\n"
                , getName(), getLifepoints(), getAttack());
    }
}