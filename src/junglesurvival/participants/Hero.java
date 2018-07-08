package junglesurvival.participants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import junglesurvival.exceptions.InvalidNameException;
import junglesurvival.items.*;


public abstract class Hero extends Participant {

  //Sample constants
  private static final int EXPERIENCE_FOR_LEVELING_UP = 45;
  private static final int BONUS_ATTACK_FOR_LEVELING_UP = 2;
  private static final int BONUS_LIFE_ON_LEVELING_UP = 15;
  private static final int MAX_ATTACK_FROM_ITEMS = 45;

  private Gender gender;
  private int experience;
  private List<Item> bag;
  private LinkedList<Jewel> jewels;
  private int level; //adding hero level as flying tiger requires it.
  private int attackFromItems;
  //private int currentAttack; //Removing this all attack functionality now reworked to base attack

  protected Hero(String name, int lifePoints, int attack, Gender gender) throws InvalidNameException {
    super(name, lifePoints, attack);
    setGender(gender);
    this.bag = new ArrayList<>();
    this.jewels = new LinkedList<>();
    this.level = 1;
    this.attackFromItems = 0;
  }

  public int getLevel() {
    return level;
  }

  private Gender getGender() {
      return gender;
  }

  public int getExperience() {
      return experience;
  }

  public List<Item> getBag() {
      return new ArrayList<>(bag);
  }

  private LinkedList<Jewel> listOfJewels() {
      return new LinkedList<>(jewels);
  }

  public void eats(Food food) {
      setLifepoints(getLifepoints() + food.beingConsumed());
      this.bag.remove(food);
  }

  public void drinkPotion(Potion potion) {

      if (potion.getType().equals(PotionType.HEALTH)) {
          setLifepoints(getLifepoints() + potion.beingConsumed());
      } else if (potion.getType().equals(PotionType.EXPERIENCE)){
          setExperience(potion.beingConsumed());
      }
      this.bag.remove(potion);
  }

  public void pickItem(Item item) {

        if (item instanceof Jewel) {
            jewels.add((Jewel) item);
        } else {
            if (item instanceof Weapon)
                if((attackFromItems + ((Weapon) item).getBonusAttack())<MAX_ATTACK_FROM_ITEMS) {
                    int attackWithoutItems=getAttack()-attackFromItems;
                    attackFromItems += ((Weapon) item).getBonusAttack();
                    setAttack(attackWithoutItems + attackFromItems);//Weapons now increase base attack.
                }
                else
                    attackFromItems=MAX_ATTACK_FROM_ITEMS;
          bag.add(item);
        }
    }

  public void bribe(Boss boss){
      useJewel(JewelColor.RED);
  }

  public boolean hasJewel(JewelColor color){
      Predicate<Jewel> colour = jewel -> jewel.getColor().equals(color);
      return listOfJewels().stream().anyMatch(colour);
  }

    public void bribe(Monster monster){
        useJewel(JewelColor.BLUE);
    }

    public abstract void attackEnemy(Enemy enemy);

    public void status() {
        System.out.printf("This %s %d-th level hero %s has %d lifepoints, %d experience \n" +
                        " %d current attack and a bag with following items:\n", getGender(), getLevel(), getName(),
                getLifepoints(), getExperience(), getAttack());
        bag.forEach(System.out::println);
    }

    public boolean hasConsumable(){
        return getBag().stream().anyMatch(item -> item instanceof Consumable);
    }

    private void levelUp() {

        setLifepoints(getLifepoints() + BONUS_LIFE_ON_LEVELING_UP);
        setAttack(getAttack() + BONUS_ATTACK_FOR_LEVELING_UP);
        level++;
        System.out.print("You are getting stronger! Your level now is " + getLevel() +
                ".\nYour life points and attack are increased!\n");
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    boolean hasRangeWeapn(){
       return getBag().stream().filter(item -> item instanceof Weapon)
               .anyMatch(item -> ((Weapon) item).getType().equals(WeaponType.RANGE));
    }

    void setExperience(int bonusExperience) {

        int leftoverExperience = experience + bonusExperience;

        while (leftoverExperience >= EXPERIENCE_FOR_LEVELING_UP) {
            leftoverExperience -= EXPERIENCE_FOR_LEVELING_UP;
            levelUp();
        }
        experience = leftoverExperience;
    }

    private void useJewel(JewelColor color){

        jewels.sort(Comparator.comparing(Jewel::getColor));
       if(jewels.getFirst().getColor().equals(color)){
           jewels.removeFirst();
       } else if (jewels.getLast().getColor().equals(color)){
           jewels.removeLast();
       }
    }

  @Override
  public String toString() {
     return super.toString() + String.format("Level: %d\n", level);
  }
}