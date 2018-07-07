package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public class FlyingTiger extends Monster implements Flyable{
  private static final int HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED = 3;

  public FlyingTiger() throws InvalidNameException {
    super("FlyingTiger");

  }

  @Override
  protected void fierceAttack(Hero hero) {
    int currentHeroLifepoints = hero.getLifepoints();
    hero.setLifepoints(currentHeroLifepoints - (getAttack() + 2));
  }

  @Override
  public void attack (Hero hero) {
    if(hero.getLevel() < HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED){
      fierceAttack(hero);
    } else {
      super.attack(hero);
    }
  }

  @Override
  public void fly() {
    System.out.printf("The %s can fly! Do you have a range weapon?", this.getName());
  }
}
