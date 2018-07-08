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
            return healthPoint;
        }
//         returns negative value of healthpoint
        return 0 - (healthPoint/3);
    }

    @Override
    public String toString() {
        return String.format("%s - this is food" , super.toString());
    }
}
