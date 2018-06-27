package junglesurvival.participants;

public class Monster extends Enemy {

    public Monster(String name, int lifepoints, int attack) {
        super(name, lifepoints, attack);
    }

    @Override
    public void attack(Hero hero) {
        hero.setLifepoints(hero.getLifepoints() - super.getAttack());
    }
}
