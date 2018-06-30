package junglesurvival.items;


public class Food extends Item implements Consumable{
    private boolean isGood;
    private int healthPoint;

    public Food(String name, boolean isGood, int healthPoint) {
        super(name);
        this.isGood = isGood;
        this.healthPoint = healthPoint;
    }

    @Override
    public int beingConsumed() {
        if(isGood){
            return healthPoint;
        }
//         returns negative value of healthpoint
        return 0 - healthPoint;
    }

    @Override
    public String toString() {
        return "This is food\n";
    }

}
