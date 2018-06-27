package junglesurvival.Items;

import junglesurvival.participants.Participant;

public class Food extends Item implements Consumable{
    private boolean isGood;
    private int healthpoint;

    public Food(String name, boolean isGood, int healthpoint) {
        super(name);
        this.isGood = isGood;
        this.healthpoint = healthpoint;
    }

    @Override
    public void beingConsumed(Participant eater) {
        if(isGood) eater.setLifepoints(eater.getLifepoints() + healthpoint);
        else eater.setLifepoints(eater.getLifepoints() - healthpoint);
    }

}
