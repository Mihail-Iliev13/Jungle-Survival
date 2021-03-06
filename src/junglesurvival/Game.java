package junglesurvival;

import junglesurvival.exceptions.InvalidNameException;
import junglesurvival.items.*;
import junglesurvival.participants.*;
import java.util.Scanner;

public class Game {
    //Constants
    private static final int FIELD_LENGTH = 20;

    public static void main(String[] args) {
        //useful stuff
        Scanner sc = new Scanner(System.in);
        Dice dice = new Dice();

        //Variables:
        Enemy exampleEnemy;
        int diceValue;
        Item nextItem;
        Enemy nextEnemy;
        String heroChoice = "";
        int stepsCount = 0;
        Hero character = null;

        //Introduction to the game
        System.out.println("Greetings summoner," +
                "\n you found yourself in a Jungle. You can now choose a Hero to help you get trough it." +
                "\n First choose your Hero's name: ");
        String characterName = sc.nextLine();
        //Intended additional verification
        while (characterName.length() < 3 || characterName.length() > 15 || !Character.isUpperCase(characterName.charAt(0))) {
            System.out.println("Please enter a valid name between 3 and 15 characters with Capital first letter! Thank you.");
            characterName = sc.nextLine();
        }

        System.out.println("Next, you can choose a class for the Hero: ");

        while (!heroChoice.equals("1") && !heroChoice.equals("2")) {
            System.out.println(
                    "1: Warrior - a male champion with 200 health points, 10 attack points and a low chance of striking a special attack - gives 3 bonus attack points. Total(13);\n" +
                            "Warrior's special attack can critically strike for two times his attack points(20) + 3 bonus. Total(23);\n\n" +
                            "2: Amazon - a female fighter with 150 health points, 8 attack points and a high chance of striking a special attack. - gives 6 bonus attack points. Total(14);\n" +
                            "Amazon's special attack can critically strike for her attack points plus two times her special attack's bonus points(12). Total(20)" +
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

        //Game info:
        System.out.println("Great, your Hero's now set.\n" +
                "The way you move forward is similar to a board game - throwing a dice.\n" +
                "You have 7 different things you can encounter: Jewel, Potion, Food, Weapon, Animal, Monster and Boss\n" +
                "You can use the Jewels to Skip challenges.\n" +
                "Potions can be Health or Experience potions.\n" +
                "Weapons have different attack powers and different range- mele or ranged.\n" +
                "An animal is a creature that won't attack you unless you attack it and has no special attacks\n" +
                "A monster is a creature that will attack you if you encounter it! It can sometimes use a fierce attack, which is stronger than its usual attacks.\n" +
                "A boss is a really strong creature that has special attacks and will attack on encounter.\n\n" +
                "Now comes your first step trough the Jungle.\n" +
                "Press Enter to throw the dice:");
        sc.nextLine();

        System.out.println("You rolled 6");
        try {
            exampleEnemy = new Chupacabra();
            printEnemyInfo(exampleEnemy);
            fight(character, exampleEnemy, sc);
        } catch (InvalidNameException e) {
            e.printMessage();
        }

        System.out.println("Now you've started your journey. Good luck and have fun! :D");
        //Here the game starts and it'll finnish when you die or when you cross the field
        while (stepsCount <= FIELD_LENGTH) {
            System.out.println("Press Enter to throw the dice:");
            sc.nextLine();
            diceValue = dice.getValue(7);
            System.out.println("You rolled " + diceValue + ".");
            stepsCount += diceValue;
            if (diceValue <= 4) {
                nextItem = nextItemEncounter(diceValue);
                printItemInfo(nextItem);
                character.pickItem(nextItem);
                if(nextItem instanceof Weapon)
                    System.out.println("Your attack power is now "+character.getAttack());
                continue;
            } else {
                nextEnemy = nextEnemyEncounter(diceValue);
                printEnemyInfo(nextEnemy);
                fight(character, nextEnemy, sc);

            }

            if(character.getLifepoints()<=0)
                break;
        }

        character.status();

        if (character.getLifepoints() > 0)
            System.out.println("----------------------------\nCongratulations!!!\n" + "    YOU WON!!!\n----------------------------");
        else
            System.out.println("---------------\n" + "Game Over!\n---------------");
    }

    //Creates the next enemy you will encounter using a dice object and a value from a dice
    private static Enemy nextEnemyEncounter(int value) {

        Dice dice = new Dice();

        switch (value) {
            case 5:
                try {
                    switch (dice.getValue(3)) {
                        case 1:
                            Animal lion = new Animal(AnimalType.LION);
                            lion.makeSound();
                            return lion;
                        case 2:
                            Animal elephant = new Animal(AnimalType.ELEPHANT);
                            elephant.makeSound();
                            return elephant;
                        case 3:
                            Animal monkey = new Animal(AnimalType.MONKEY);
                            monkey.makeSound();
                            return monkey;
                    }
                } catch (InvalidNameException e) {
                    e.printMessage();
                }
                break;
            case 6:
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
            case 7:
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
                return null;
        }
        //never reachable but necessary
        return null;
    }

    //Creates the next item you will encounter using a dice object and a value from a dice
    private static Item nextItemEncounter(int value) {

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
                        return new Weapon("Excalibur", 10, WeaponType.MELE);
                    case 2:
                        return new Weapon("Samurai Katana", 8, WeaponType.MELE);
                    case 3:
                        return new Weapon("Ancient enchanted Bow", 9, WeaponType.RANGE);
                }
                break;
            case 4:
                return new Food("Mushrooms");
        }
        return null;
    }

    //prints what item you've encountered
    private static void printItemInfo(Item item) {
        if (item instanceof Jewel)
            System.out.println("You encountered a " + ((Jewel) item).getColor().toString().toLowerCase() + " Jewel and it's now in your bag.");
        else if (item instanceof Food)
            System.out.println("You encountered a Food item and it's now in your bag.");
        else if (item instanceof Potion)
            System.out.println("You encountered a " + ((Potion) item).getType().toString().toLowerCase() + " Potion that has a value of: " + ((Potion) item).getBonus() + " and it's now in your bag.");
        else
            System.out.println("You encountered a " + ((Weapon) item).getType().toString().toLowerCase() + " Weapon with " + ((Weapon) item).getBonusAttack() + " bonus attack and it's now in your bag.");
    }

    //prints what enemy you've encountered
    private static void printEnemyInfo(Enemy enemy) {
        if (enemy instanceof Flyable) {
            System.out.println("You encountered " + enemy.getName() + ". ");
            ((Flyable) enemy).fly();
        } else if (enemy instanceof Animal)
            System.out.println("You encountered an Animal!");
        else if (enemy instanceof Monster)
            System.out.println("You encountered " + enemy.getName() + ". It's a Monster!");
        else
            System.out.println("You encountered " + enemy.getName() + ". It's a Boss!");
    }

    //prints the correct menu in the middle of the fight
    private static void printEnemyOptions(Hero hero, Enemy enemy) {
        if (enemy instanceof Animal)
            System.out.println("Choose:\n" +
                    "1: Attack;\n" +
                    "2: View inventory;\n" +
                    "3: Skip.");
        else if (enemy instanceof Boss) {
            if (hero.hasJewel(JewelColor.RED))
                System.out.println("Coose:\n" +
                        "1: Attack;\n" +
                        "2: View inventory;\n" +
                        "3: Skip.");
            else
                System.out.println("Choose:\n" +
                        "1: Attack.\n" +
                        "2: View inventory;");
        } else {
            if (hero.hasJewel(JewelColor.BLUE))
                System.out.println("Choose:\n" +
                        "1: Attack;\n" +
                        "2: View inventory;\n" +
                        "3: Skip.");
            else
                System.out.println("Choose:\n" +
                        "1: Atatck.\n" +
                        "2: View inventory;");
        }
    }

    //Returns whether you can Skip an enemy or not. If it's not an animal,
    //the method searches the jewels field of the hero and returns whether you have the necessity to Skip the enemy
    private static boolean canSkip(Hero hero, Enemy enemy) {
        if (enemy instanceof Animal)
            return true;
        else if (enemy instanceof Boss) {
            return hero.hasJewel(JewelColor.RED);
        } else {
            return hero.hasJewel(JewelColor.BLUE);
        }
    }
    //maybe make Enemy abstract and put an abstract status method so each enemy can print it's values
    private static void printEnemyStatus(Enemy enemy) {
        System.out.println(enemy.getName() + ":\nlife points: " + enemy.getLifepoints());
    }

    //same
    private static void printCharacterStatus(Hero hero) {
        System.out.println("You:\nlife points: " + hero.getLifepoints());
    }

    //called on every encounter of an enemy and executed until the hero or the enemy dies
    private static void fight(Hero hero, Enemy enemy, Scanner sc) {
        int enemyInitialPoints = enemy.getLifepoints();
        while (hero.getLifepoints() > 0 && enemy.getLifepoints() > 0) {
            if (!(enemy instanceof Animal))
                enemy.attack(hero);
            if (canSkip(hero, enemy)) {
                whileLoop:
                while (true) {
                    printEnemyOptions(hero, enemy);
                    String userChoice = sc.nextLine();
                    switch (userChoice) {
                        case "1":
                            hero.attackEnemy(enemy);
                            break whileLoop;
                        case "3":
                          if (enemy instanceof Monster){
                            hero.bribe((Monster) enemy);
                          } else if (enemy instanceof Boss){
                            hero.bribe((Boss) enemy);
                          }
                            System.out.println("You've Skipped " + enemy.getName());
                            return;
                        case "2":
                            if (!hero.hasConsumable()) {
                                System.out.println("Bag is empty");
                                continue;
                            }
                            hero.getBag().stream().filter(item -> item instanceof Consumable).forEach(item -> {
                                System.out.print(hero.getBag().indexOf(item)  + " ");
                                item.printItem();
                            });
                            System.out.println("Choose the item you want to consume.");
                            String str = sc.nextLine();
                            if (!str.matches("-?\\d+") || !hero.getBag().stream()
                                    .filter(item->item instanceof Consumable).anyMatch(item -> {
                                String index=String.valueOf(hero.getBag().indexOf(item));
                                return str.equals(index);
                            })){
                                System.out.println("Invalid input");
                                continue;
                            }
                            int toConsume = Integer.parseInt(str);
                            if (hero.getBag().get(toConsume) instanceof Potion) {
                                hero.drinkPotion((Potion) hero.getBag().get(toConsume));
                            } else {
                                hero.eats((Food) hero.getBag().get(toConsume));
                            }
                    }
                }
            } else {
                whileLoop:
                while (true) {
                    printEnemyOptions(hero, enemy);
                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            hero.attackEnemy(enemy);
                            break whileLoop;
                        case "2":
                            if (!hero.hasConsumable()) {
                                System.out.println("Bag is empty");
                                continue;
                            }
                            hero.getBag().stream().filter(item -> item instanceof Consumable).forEach(item -> {
                                System.out.print(hero.getBag().indexOf(item) + " ");
                                item.printItem();
                            });
                            System.out.println("Choose the item you want to consume.");
                            String str = sc.nextLine();
                            if (!str.matches("-?\\d+")||!hero.getBag().stream().filter(item->item instanceof Consumable).anyMatch(item -> {
                                String index=String.valueOf(hero.getBag().indexOf(item));
                                return str.equals(index);
                            })) {
                                System.out.println("Invalid input");
                                continue;
                            }
                            int toConsume = Integer.parseInt(str);
                            if (hero.getBag().get(toConsume) instanceof Potion) {
                                hero.drinkPotion((Potion) hero.getBag().get(toConsume));
                            } else {
                                hero.eats((Food) hero.getBag().get(toConsume));
                            }
                    }
                }
            }
            if (enemy instanceof Animal)
                if (enemyInitialPoints != enemy.getLifepoints())
                    enemy.attack(hero);

            printCharacterStatus(hero);
            printEnemyStatus(enemy);
        }
        if (enemy.getLifepoints() <= 0)
            System.out.println(enemy.getName() + " is killed. You got " + enemy.getGivenExperience()
                    + " more experience. Your level is now "+hero.getLevel() + " and you have "
                    + hero.getExperience() + " experience.");

    }
}
