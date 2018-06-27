package junglesurvival.Items;

import junglesurvival.participants.Participant;

public class Food extends Item implements Consumable{
    private boolean isGood;
    private int healthpoint;

    @Override
    public void beingConsumed(Participant eater) {
        if(isGood) eater.setLifepoints(eater.getLifepoints() - healthpoint);
        else eater.setLifepoints(eater.getLifepoints() + healthpoint);
    }
}
