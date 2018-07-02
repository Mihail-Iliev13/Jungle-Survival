package junglesurvival;

import junglesurvival.Exceptions.InvalidNameException;
import junglesurvival.items.*;
import junglesurvival.participants.*;

import java.util.Scanner;

public class ExampleLogic {
    //Constants
    private static final int FIELD_LENGTH = 15;

    public static void main(String[] args) {
        //usefull stuff
        Scanner sc = new Scanner(System.in);
        Dice dice = new Dice();

        //Variables:
        Item nextItem;
        Enemy nextEnemy;
        String heroChoice = "";
        Gender gender = null;
        int stepsCount = 0;
        Hero character = null;


        System.out.println("Greetings summoner," +
                "\n you found yourself in a Jungle. You can now choose a Hero to help you get trough it." +
                "\n First choose your name: ");
        String characterName = sc.nextLine();
        //todo I prefer to put validation of all inputs here as I am unsure we should resolve it as exception?
        while (characterName.length() < 3 || characterName.length() > 15 || !Character.isUpperCase(characterName.charAt(0))) {
            System.out.println("Please enter a valid name between 3 and 15 characters with Capital first letter! Thank you.");
            characterName = sc.nextLine();
        }

        System.out.println("Next, you can choose a class of the Hero: ");


        while (!heroChoice.equals("1") && !heroChoice.equals("2")) {
            System.out.println(
                    "1: Warrior - a male champion with 200 health points, 20 attack points and a low chance of striking a special attack - gives 5 bonus attack points. Total(25);\n" +
                            "Warrior's special attack can critically strike for two times his attack points(40) + 5 bonus. Total(45);\n\n" +
                            "2: Amazon - a female fighter with 150 health points, 15 attack points and a high chance of striking a special attack. - gives 10 bonus attack points. Total(25);\n" +
                            "Amazon's special attack can critically strike for her attack points plus two times her special attack's bonus points(20). Total(35)" +
                            "Enter the number of your choice: ");
            try {
                switch (heroChoice = sc.nextLine()) {
                    case "1":
                        character = new Warrior(characterName);
                        break;
                    case "2":
                        character = new Amazon(characterName);
                        break;
                    default:
                        System.out.println("Invalid input!\n Press Enter to try again.");
                        sc.nextLine();
                }
            } catch (InvalidNameException e) {
                e.printMessage();
            }
        }
        System.out.println("Great, your Hero's now set.\n" +
                "The way you move forward is similar to a board game - throwing a dice.\n" +
                "You have 6 different things you can meet: Jewel, Potion, Weapon, Animal, Monster and Boss\n" +
                "You can use the Jewels to skip challenges.\n" +
                "Potions can be Health or Experience potions.\n" +
                "Weapons have different attack powers and different range- mele or ranged.\n" +
                "An animal is a creature that won't attack you unless you attack it and has no special attacks\n" +
                "A monster is a creature that will attack you if you encounter it! It can sometimes use a fierce attack, which is stronger than its usual attacks.\n" +
                "A boss is a really strong creature that has special attacks and will attack on encounter.\n\n" +
                "Now comes your first step trough the Jungle.\n" +
                "Press Enter to throw the dice:");
        sc.nextLine();

        nextEnemy=(Animal)nextEncounter(4);


    }

    public static Object nextEncounter(int value) {

        Dice dice = new Dice();

        switch (value) {
            case 1:
                switch (dice.getValue(2)) {
                    case 1:
                        return new Jewel("Blue Jewel", JewelColor.BLUE);
                    case 2:
                        return new Jewel("Red Jewel", JewelColor.RED);
                }
                break;
            case 2:
                switch (dice.getValue(2)) {
                    case 1:
                        return new Potion("Experience Potion", PotionType.EXPERIENCE);
                    case 2:
                        return new Potion("Healing Potion", PotionType.HEALTH);
                }
                break;
            case 3:
                switch (dice.getValue(3)) {
                    case 1:
                        return new Weapon("Greatsword", 10, WeaponType.MELE);
                    case 2:
                        return new Weapon("Katana", 8, WeaponType.MELE);
                    case 3:
                        return new Weapon("Ancient encahnted Bow", 9, WeaponType.RANGE);
                }
                break;
            case 4:
                try {
                    switch (dice.getValue(3)) {
                        case 1:
                            return new Animal(AnimalType.LION);
                        case 2:
                            return new Animal(AnimalType.ELEPHANT);
                        case 3:
                            return new Animal(AnimalType.MONKEY);
                    }
                } catch (InvalidNameException e) {
                    e.printMessage();
                }
                break;
            case 5:
                try {
                    switch (dice.getValue(3)) {
                        case 1:
                            return new Chupacabra();
                        case 2:
                            return new FlyingTiger();
                        case 3:
                            return new KingKong();
                    }
                } catch (InvalidNameException e) {
                    e.printMessage();
                }
                break;
            case 6:
                try {
                    switch (dice.getValue(2)) {
                        case 1:
                            return new AngrySlicer();
                        case 2:
                            return new LordOfTheFlies();
                    }
                } catch (InvalidNameException e) {
                    e.printMessage();
                }
                break;
            default:
        }
        return null;
    }


}
