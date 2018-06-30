package junglesurvival.participants;




public abstract class Monster extends Enemy {

    protected static final int REGULAR_DAMAGE_PER_ATTACK = 3;
    protected static final int MONSTER_STARTING_LIFE_POINTS = 15;
    protected static final int MONSTER_GIVEN_EXPERIENCE = 3;

    public Monster(String name) {
        super(name);
        setLifepoints(MONSTER_STARTING_LIFE_POINTS);
        setAttack(REGULAR_DAMAGE_PER_ATTACK);
        setGivenExperience(MONSTER_GIVEN_EXPERIENCE);
    }

    protected abstract void fight(Hero hero);

    protected abstract void fierceAttack(Hero hero);

  @Override
  public void attack(Hero hero) {

    if (this.getAttack() > REGULAR_DAMAGE_PER_ATTACK){
      this.setAttack(REGULAR_DAMAGE_PER_ATTACK);
    }

    int heroCurrentLifepoints = hero.getLifepoints();
    hero.setLifepoints(heroCurrentLifepoints - REGULAR_DAMAGE_PER_ATTACK);
  }
}
