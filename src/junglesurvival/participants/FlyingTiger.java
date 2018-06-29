package junglesurvival.participants;

public class FlyingTiger extends Monster implements Flyable{
  private static final int HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED = 3;

  public FlyingTiger(String name) {
    super(name);

  }

  @Override
  protected void fierceAttack(Hero hero) {
    int currentHeroLifepoints = hero.getLifepoints();
    hero.setLifepoints(currentHeroLifepoints - (this.getAttack() + 2));
  }

  @Override
  public void fight (Hero hero) {
    if(hero.getExperience() < HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED){
      fierceAttack(hero);
    } else {
      if (this.getAttack() > REGULAR_DAMAGE_PER_ATTACK){
        this.setAttack(REGULAR_DAMAGE_PER_ATTACK);
      }
      int currentLifepoints = hero.getLifepoints();
      hero.setLifepoints(currentLifepoints - this.getAttack());    }
  }

  @Override
  public void fly() {
    System.out.printf("The %s can fly! He is invulnerable to your your weapon!", this.getName());
  }
}
