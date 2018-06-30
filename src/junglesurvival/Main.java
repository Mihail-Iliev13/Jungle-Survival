package junglesurvival;

import junglesurvival.items.*;


public class Main {

    public static void main(String[] args) {
      Potion magic = new Potion("Magic", PotionType.EXPERIENCE);
      Food mushroom = new Food("Mushroom", true, 32);
      Weapon axe = new Weapon("Axe", 32, WeaponType.RANGE);
      Jewel jewel = new Jewel("Rubin", JewelColor.RED);

      System.out.println(magic.toString());
      System.out.println(mushroom.toString());
      System.out.println(axe.toString());
      System.out.println(jewel.toString());



        System.out.println(1/3);
//        System.out.println("hello");
//        Hero opra = new Hero("Opra", 100, 30, Gender.FEMALE);
//        Monster stryvnik = new Monster("ManEater", 40, 10,70);
//        Weapon bow = new Weapon("GreatBow", 10);
//        Jewel diamond = new Jewel("BigDiamond", JewelColor.BLUE);
//        Food mushroom = new Food("Muhomorka", false, 40);
//        Potion healthPotion=new Potion("HealthElixir", PotionType.HEALTH);
//        Potion experiencePotion=new Potion("ExperienceBooster", PotionType.EXPERIENCE);
//        opra.attackEnemy(stryvnik);
//        stryvnik.attack(opra);
//        opra.status();
//        System.out.println("stryvnik has following lifepoints: " + stryvnik.getLifepoints());
//        opra.eats(mushroom);
//        healthPotion.beingConsumed(opra);
//        experiencePotion.beingConsumed(opra);
//        opra.attackEnemy(stryvnik);
//        opra.pickItem(bow);
//        opra.pickItem(diamond);
//        opra.status();

    }
}
