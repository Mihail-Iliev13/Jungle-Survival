package junglesurvival.participants;

public class Monster extends Enemy {

    public Monster(String name, int lifepoints, int attack) {
        super(name, lifepoints, attack);
    }

    @Override
    public void attack(Hero hero) {
        // deals non-modified dmg to hero -> unconditional (different from animal and boss)
        hero.setLifepoints(hero.getLifepoints() - super.getAttack());
    }
}
