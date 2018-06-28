package junglesurvival.items;

import junglesurvival.participants.Hero;

public class Potion extends Item implements Consumable {

    private static final int HEALTH_POTION_BONUS=30;
    private static final int EXPERIENCE_POTION_BOUNS=100;

    private PotionType type;
    private int bonus;


    public Potion(String name, PotionType type) {
        super(name);
        this.type=type;
        setBonus(type);
    }

    public int getBonus() {
        return bonus;
    }

    private void setBonus(PotionType type) {
        if(type.equals(PotionType.EXPERIENCE))
            this.bonus = EXPERIENCE_POTION_BOUNS;
        else if(type.equals(PotionType.HEALTH))
            this.bonus =HEALTH_POTION_BONUS;
    }

    @Override
    public void beingConsumed(Hero eater) {
        if(type.equals(PotionType.HEALTH))
            eater.setLifepoints(eater.getLifepoints()+bonus);
        else if(type.equals(PotionType.EXPERIENCE))
            eater.setExperience(bonus);//TODO maybe we should rename setExp() to meet new functionality?

    }
}
