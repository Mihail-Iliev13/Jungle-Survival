package junglesurvival.items;


public class Potion extends Item implements Consumable {

    private static final int HEALTH_POTION_BONUS = 30;
    private static final int EXPERIENCE_POTION_BONUS = 100;

    private PotionType type;
    private int bonus;

    public Potion(String name, PotionType type) {
        super(name);
        this.type = type;
        setBonus(type);
    }

    public int getBonus() {
        return bonus;
    }

    private void setBonus(PotionType type) {
        if(type.equals(PotionType.EXPERIENCE))
            this.bonus = EXPERIENCE_POTION_BONUS;
        else if(type.equals(PotionType.HEALTH))
            this.bonus = HEALTH_POTION_BONUS;
    }

    public PotionType getType() {
        return type;
    }

    @Override
    public int beingConsumed() {
       return bonus;
    }

     @Override
    public String toString() {
    return String.format("This is potion of type: %s\n", getType().toString().toLowerCase());
  }


}
