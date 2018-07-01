package junglesurvival.participants;

import junglesurvival.items.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Participant {

  //Sample constants
  private static final int EXPERIENCE_FOR_LEVELING_UP = 50;
  private static final int BONUS_ATTACK_FOR_LEVELING_UP = 10;
  private static final int BONUS_LIFE_ON_LEVELING_UP = 50;

  private Gender gender;
  private int experience;
  private List<Item> bag;
  private List<Jewel> bribAbility;
  private int level; //adding hero level as flying tiger requires it.
  //private int currentAttack; //Removing this all attack functionality now reworked to base attack

  public Hero(String name) {
    super(name);
    bag = new ArrayList<>();
    bribAbility = new ArrayList<>();
    level = 0;
  }

  public void pickItem(Item item) {
    bag.add(item);
    if (item instanceof Weapon)
      setAttack (getAttack() + ((Weapon) item).getBonusAttack()); //Weapons now increase base attack.

    if (item instanceof Jewel) bribAbility.add((Jewel) item);
  }

  public abstract void attackEnemy(Enemy enemy);


  private void levelUp() {
    super.setLifepoints(getLifepoints() + BONUS_LIFE_ON_LEVELING_UP);
    super.setAttack(getAttack() + BONUS_ATTACK_FOR_LEVELING_UP);
    level ++;
      System.out.print("You are getting stronger!\n" +
              "Your life points and attack are increased!\n");
  }

  public void status() {
    System.out.printf("This %s %d-th level hero %s has %d lifepoints, %d experience \n" +
                    " %d current attack and a bag with following items:\n", gender, level, super.getName(),
            super.getLifepoints(), experience, getAttack());
    bag.forEach(System.out::println);
//        bag.stream().filter(x -> x instanceof Consumable).forEach(System.out::println);
  }

  public int getLevel() {
      return level;
  }

  public int getExperience() {
    return experience;
  }

  protected void setExperience(int bonusExperience) {

    int leftoverExperience = experience + bonusExperience;

    while (leftoverExperience >= EXPERIENCE_FOR_LEVELING_UP) {
      leftoverExperience -= EXPERIENCE_FOR_LEVELING_UP;
      levelUp();
    }
    experience = leftoverExperience;
  }

    public Gender getGender() {
        return gender;
    }

    protected void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Item> getBag() {
        return new ArrayList<>(bag);
    }

    public void setBag(List<Item> bag) {
        this.bag = bag;
    }

    public List<Jewel> getBribAbility() {
        return new ArrayList<>(bribAbility);
    }

    public void setBribAbility(List<Jewel> bribAbility) {
        this.bribAbility = bribAbility;
    }

    public void eats(Food food) {
    setLifepoints(this.getLifepoints() + food.beingConsumed());
  }

    public void drinkPotion(Potion potion){
    if(potion.getType().equals(PotionType.HEALTH))
      setLifepoints(getLifepoints() + potion.beingConsumed());
        else if(potion.getType().equals(PotionType.EXPERIENCE))
           setExperience(potion.beingConsumed());
  }

  @Override
  public String toString() {
    return super.toString() + String.format("Level: %d\n", level);
  }
}