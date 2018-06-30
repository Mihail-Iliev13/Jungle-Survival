package junglesurvival.items;

public class Weapon extends Item {

    private int bonusAttack;
    private WeaponType type;

    public Weapon(String name, int bonusAttack, WeaponType type) {
        super(name);
        this.bonusAttack = bonusAttack;
        this.type = type;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public WeaponType getType() {
        return type;
    }

    public void setBonusAttack(int bonusAttack) {
        this.bonusAttack = bonusAttack;
    }

    @Override
    public String toString() {
        return String.format("This is weapon of type: %s\n", getType());
    }
}
