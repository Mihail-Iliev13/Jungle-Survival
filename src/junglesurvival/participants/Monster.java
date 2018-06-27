package junglesurvival.participants;

public class Monster extends Enemy {

    public Monster(String name, int lifepoints, int attack, int expGiven) {
        super(name, lifepoints, attack, expGiven);
    }

    @Override
    public void attack(Hero hero) {
        // deals non-modified dmg to hero -> unconditional (different from animal and boss)
        hero.setLifepoints(hero.getLifepoints() - super.getAttack());
    }
}
