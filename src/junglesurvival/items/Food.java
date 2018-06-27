package junglesurvival.items;

import junglesurvival.participants.Hero;

public class Food extends Item implements Consumable{
    private boolean isGood;
    private int healthPoint;

    public Food(String name, boolean isGood, int healthPoint) {
        super(name);
        this.isGood = isGood;
        this.healthPoint = healthPoint;
    }

    @Override
    public void beingConsumed(Hero eater) {
        if(isGood) eater.setLifepoints(eater.getLifepoints() + healthPoint);
        else eater.setLifepoints(eater.getLifepoints() - healthPoint);
    }

}
