package junglesurvival.participants;

import junglesurvival.exceptions.InvalidNameException;

public abstract class Monster extends Enemy {

    private static final int REGULAR_DAMAGE_PER_ATTACK = 5;
    private static final int MONSTER_STARTING_LIFE_POINTS = 25;
    private static final int MONSTER_GIVEN_EXPERIENCE = 15;

    protected Monster(String name) throws InvalidNameException {
        super(name, MONSTER_STARTING_LIFE_POINTS, REGULAR_DAMAGE_PER_ATTACK, MONSTER_GIVEN_EXPERIENCE);
    }

    protected abstract void fierceAttack(Hero hero);

  @Override
  public void attack(Hero hero) {

    if (this.getAttack() != REGULAR_DAMAGE_PER_ATTACK){
      this.setAttack(REGULAR_DAMAGE_PER_ATTACK);
    }
    int heroCurrentLifepoints = hero.getLifepoints();
    hero.setLifepoints(heroCurrentLifepoints - REGULAR_DAMAGE_PER_ATTACK);
  }
}
