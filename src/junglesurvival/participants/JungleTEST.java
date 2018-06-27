package junglesurvival.participants;

import junglesurvival.Items.Food;
import junglesurvival.Items.Jewel;
import junglesurvival.Items.Weapon;

public class JungleTEST {
    static void main(String[] args) {

        Hero opra = new Hero("Opra", 100, 30, Gender.FEMALE);
        Monster stryvnik = new Monster("ManEater", 40, 10,70);
        Weapon bow = new Weapon("GreatBow", 10);
        Jewel diamond = new Jewel("BigDiamond");
        Food mushroom = new Food("Muhomorka", false, 40);
        opra.attackEnemy(stryvnik);
        stryvnik.attack(opra);
        opra.status();
        System.out.println(stryvnik.getLifepoints());
        mushroom.beingConsumed(opra);
        opra.attackEnemy(stryvnik);
        opra.pickItem(bow);
        opra.pickItem(diamond);
        opra.status();
    }
}
