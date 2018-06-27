package junglesurvival.participants;

import junglesurvival.Items.Item;
import junglesurvival.Items.Jewel;
import junglesurvival.Items.Weapon;

import java.util.ArrayList;
import java.util.List;

enum Gender {
    MALE, FEMALE
}

public class Hero extends Participant {
    private Gender gender;
    private int experience;
    private List<Item> bag;
    private List<Jewel> bribAbility;
    private int currentAttack;

    public Hero(String name, int lifepoints, int attack, Gender gender) {
        super(name, lifepoints, attack);
        this.gender = gender;
        bag = new ArrayList<>();
        bribAbility = new ArrayList<>();
        currentAttack = super.getAttack();
    }

    void pickItem(Item item) {
        bag.add(item);
        if(item instanceof Weapon) currentAttack ++; //change when weapon is finished!!!
        if(item instanceof Jewel) bribAbility.add((Jewel)item);
    }

    void attackEnemy(Enemy enemy) {
    enemy.setLifepoints(enemy.getLifepoints() - currentAttack);
    }

}
