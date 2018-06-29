package junglesurvival.participants;

import junglesurvival.Dice;
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
  private int currentAttack;

  public Hero(String name) {
    super(name);
    bag = new ArrayList<>();
    bribAbility = new ArrayList<>();
    currentAttack = 0;
  }

  public void pickItem(Item item) {
    bag.add(item);
    if (item instanceof Weapon)
      currentAttack += ((Weapon) item).getBonusAttack();
    if (item instanceof Jewel) bribAbility.add((Jewel) item);
  }

  public abstract void attackEnemy(Enemy enemy);


  private void levelUp() {
    super.setLifepoints(getLifepoints() + BONUS_LIFE_ON_LEVELING_UP);
    super.setAttack(getAttack() + BONUS_ATTACK_FOR_LEVELING_UP);
    currentAttack += BONUS_ATTACK_FOR_LEVELING_UP;
  }

  public void status() {
    System.out.printf("This %s hero %s has %d lifepoints, %d experience \n" +
                    " %d current attack and a bag with following items:\n", gender, super.getName(),
            super.getLifepoints(), experience, currentAttack);
    bag.forEach(System.out::println);
    
//        bag.stream().filter(x -> x instanceof Consumable).forEach(System.out::println);
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int bonusExperience) {

    int leftoverExperience = experience + bonusExperience;

    while (leftoverExperience >= EXPERIENCE_FOR_LEVELING_UP) {
      leftoverExperience -= EXPERIENCE_FOR_LEVELING_UP;
      levelUp();
    }
    this.experience = leftoverExperience;
  }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

  public  int throwDice(){

    Dice dice=new Dice();
    return dice.getValue();

  }
}