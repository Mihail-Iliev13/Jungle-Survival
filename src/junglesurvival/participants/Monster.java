package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public abstract class Monster extends Enemy {

    protected static final int REGULAR_DAMAGE_PER_ATTACK = 3;
    protected static final int MONSTER_STARTING_LIFE_POINTS = 15;
    protected static final int MONSTER_GIVEN_EXPERIENCE = 3;

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
