package junglesurvival.participants;

import junglesurvival.Dice;
import junglesurvival.items.Consumable;
import junglesurvival.items.Item;
import junglesurvival.items.Jewel;
import junglesurvival.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Participant {

    //Sample constants
    private static final int EXPERIENCE_FOR_LEVELING_UP = 50;
    private static final int BONUS_ATTACK_FOR_LEVELING_UP = 10;
    private static final int BONUS_LIFE_ON_LEVELING_UP = 50;

    private Gender gender;
    private int experience;
    private List<Item> bag;
    private List<Jewel> bribAbility;
    private int currentAttack; //TODO lets consider spiting attack from super and this to be set only a bonus attack from items?

    public Hero(String name, int lifepoints, int attack, Gender gender) {
        super(name, lifepoints, attack);
        this.gender = gender;
        bag = new ArrayList<>();
        bribAbility = new ArrayList<>();
        currentAttack = super.getAttack();
    }

    public void pickItem(Item item) {
        bag.add(item);
        if (item instanceof Weapon)
            currentAttack += ((Weapon) item).getBonusAttack();//Implemented some logic for Weapon. - older code+comment: currentAttack++; //TODO change when weapon is finished!!!
        if (item instanceof Jewel) bribAbility.add((Jewel) item);
    }

    public void attackEnemy(Enemy enemy) {
        enemy.setLifepoints(enemy.getLifepoints() - currentAttack);

        if (enemy.getLifepoints() <= 0) killingEnemy(enemy);
    }

    private void killingEnemy(Enemy enemy) {

        setExperience(enemy.givenExperience);

        // experience += enemy.givenExperience; //this section seems redundant now
//        if (experience >= EXPERIENCE_FOR_LEVELING_UP) { //TODO set constant - added a sample constant
//            experience -= EXPERIENCE_FOR_LEVELING_UP; //TODO set constant - added a sample constant
//            levelUp();
//        }
    }

    private void levelUp() {
        super.setLifepoints(getLifepoints() + BONUS_LIFE_ON_LEVELING_UP); //TODO set to constant at some point - added a sample constant
        super.setAttack(getAttack() + BONUS_ATTACK_FOR_LEVELING_UP); //TODO DOESNT SEEM TO WORK ?-should work now/ set to constant at some point - added a sample constant
        currentAttack+=BONUS_ATTACK_FOR_LEVELING_UP;
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

    public void setExperience(int bonusExperience) { //this method now works with bonus experience and solves leveling up -> making private

        int leftoverExperience = experience + bonusExperience;
        while(leftoverExperience >= EXPERIENCE_FOR_LEVELING_UP) {
            leftoverExperience -= EXPERIENCE_FOR_LEVELING_UP;
            levelUp();
        }
        this.experience = leftoverExperience;
    }

    public void eats(Consumable consumable){
        consumable.beingConsumed(this);
    }

    public int throwDice(Dice dice){
        return dice.getValue();
    }
}
