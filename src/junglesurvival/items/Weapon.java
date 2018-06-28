package junglesurvival.items;

public class Weapon extends Item {

    private int bonusAttack;

    public Weapon(String name, int bonusAttack) {
        super(name);
        this.bonusAttack = bonusAttack;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public void setBonusAttack(int bonusAttack) {
        this.bonusAttack = bonusAttack;
    }
}
