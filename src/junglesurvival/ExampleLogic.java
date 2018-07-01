package junglesurvival;

import junglesurvival.participants.Amazon;
import junglesurvival.participants.Gender;
import junglesurvival.participants.Hero;
import junglesurvival.participants.Warrior;

import java.util.Scanner;

public class ExampleLogic {
    //Constants
    private static final int FIELD_LENGTH = 15;

    public static  void main(String[] args){
        //usefull stuff
        Scanner sc = new Scanner(System.in);
        Dice dice = new Dice();

        //Variables:
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


        while(!heroChoice.equals("1")&&!heroChoice.equals("2")) {
            System.out.println(
                    "1: Warrior - a male champion with 200 health points, 20 attack points and a low chance of striking a special attack - gives 5 bonus attack points. Total(25);\n" +
                            "Warrior's special attack can critically strike for two times his attack points(40) + 5 bonus. Total(45);\n\n" +
                    "2: Amazon - a female fighter with 150 health points, 15 attack points and a high chance of striking a special attack. - gives 10 bonus attack points. Total(25);\n" +
                            "Amazon's special attack can critically strike for her attack points plus two times her special attack's bonus points(20). Total(35)" +
                    "Enter the number of your choice: ");
            switch (heroChoice=sc.nextLine()){
                case "1":
                    character=new Warrior(characterName);
                    break;
                case "2":
                    character=new Amazon(characterName);
                    break;
                default:
                    System.out.println("Invalid input!\n Press Enter to try again.");
                    sc.nextLine();
            }
        }
        System.out.println("Great, your Hero's now set.\n" +
                "The way you move forward is similar to a board game - throwing a dice.\n" +
                "You have 6 different things you can meet: Jewel, Potion, Weapon, Animal, Monster and Boss\n" +
                "You can use the Jewels to skip challenges.\n" +
                "Potions can be Health or Experience potions.\n" +
                "Weapons have different attack powers and different range- mele or ranged.\n" +
                "Animal is a creature that won't attack you unless you attack it and has no special attacks\n " +
                "Now comes your first step trough the Jungle.\n" +
                "");


        character.status();
    }


}
