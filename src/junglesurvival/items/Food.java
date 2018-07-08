package junglesurvival.items;


import junglesurvival.Dice;

public class Food extends Item implements Consumable{

    private static final int FOOD_POINTS = 50;

    private boolean isGood;
    private int healthPoint;

    public Food(String name) {
        super(name);
        this.isGood = setIsGood();
        this.healthPoint = FOOD_POINTS;
    }

    private boolean setIsGood(){
        Dice dice = new Dice();
        return dice.getValue(2) != 1;
    }

    @Override
    public int beingConsumed() {
        if(isGood){
            System.out.println("You've eaten a healthy "+getName()+". It gave you "+healthPoint+" health points.");
            return healthPoint;
        }
        int takenLifePoints=healthPoint/3;
        System.out.println("You've eaten a poisonous "+getName()+". It took from you "+takenLifePoints+" health points.");

//         returns negative value of healthpoint
        return 0 - (takenLifePoints);
    }

    @Override
    public String toString() {
        return String.format("%s - this is food" , super.toString());
    }
}
