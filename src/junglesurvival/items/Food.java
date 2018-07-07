package junglesurvival.items;


import junglesurvival.Dice;

public class Food extends Item implements Consumable{

    private static final int FOOD_POINTS = 70;

    private boolean isGood;
    private int healthPoint;

    public Food(String name) {
        super(name);
        this.isGood = setIsGood();
        this.healthPoint = FOOD_POINTS;
    }

    private boolean setIsGood(){
        Dice dice = new Dice();
        if(dice.getValue(2) == 1){
            return false;
        } else {
            return true;
        }
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
        return "This is food\n";
    }

}
