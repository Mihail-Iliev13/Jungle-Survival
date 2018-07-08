package junglesurvival.participants;

import junglesurvival.exceptions.InvalidNameException;

public class Participant {
  private String name;
  private int lifepoints;
  private int attack;
  private static final int MIN_NAME_LENGTH = 2;
  private static final int MAX_NAME_LENGTH = 25;

  protected Participant(String name, int lifepoints, int attack) throws InvalidNameException {
    setName(name);
    setLifepoints(lifepoints);
    setAttack(attack);
  }

  public String getName() {
    return name;
  }

  public int getLifepoints() {
    return lifepoints;
  }

  public int getAttack() {
    return attack;
  }

  protected void setLifepoints(int lifepoints) {
    if(lifepoints < 0 ) {
      this.lifepoints = 0;
    } else {
      this.lifepoints = lifepoints;
    }
  }

  protected void setAttack(int attack) {
    this.attack = attack;
  }

  private void setName(String name) throws InvalidNameException {

    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH
            || !Character.isUpperCase(name.charAt(0))) {
      throw new InvalidNameException();
    } else {
      this.name = name;
    }
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nRemaining LifePoints: %d\nAttacking power: %d\n",
            getName(), getLifepoints(), getAttack());
  }
}