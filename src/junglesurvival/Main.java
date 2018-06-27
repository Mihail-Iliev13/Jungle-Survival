package junglesurvival;
import junglesurvival.items.*;

import junglesurvival.items.*;
import junglesurvival.participants.Gender;
import junglesurvival.participants.Hero;
import junglesurvival.participants.Monster;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        Hero opra = new Hero("Opra", 100, 30, Gender.FEMALE);
        Monster stryvnik = new Monster("ManEater", 40, 10,70);
        Weapon bow = new Weapon("GreatBow", 10);
        Jewel diamond = new Jewel("BigDiamond", JewelColor.BLUE);
        Food mushroom = new Food("Muhomorka", false, 40);
        Potion healthPotion=new Potion("HealthElixir", PotionType.HEALTH);
        Potion experiencePotion=new Potion("ExperienceBooster", PotionType.EXPERIENCE);
        opra.attackEnemy(stryvnik);
        stryvnik.attack(opra);
        opra.status();
        System.out.println("stryvnik has following lifepoints: " + stryvnik.getLifepoints());
        mushroom.beingConsumed(opra);
        healthPotion.beingConsumed(opra);
        experiencePotion.beingConsumed(opra);
        opra.attackEnemy(stryvnik);
        opra.pickItem(bow);
        opra.pickItem(diamond);
        opra.status();

    }
}
