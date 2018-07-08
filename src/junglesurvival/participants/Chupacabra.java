package junglesurvival.participants;

import junglesurvival.exceptions.InvalidNameException;

public class Chupacabra extends Monster {

  private static final int HERO_LIFE_POINTS_BELOW_FIERCE_ATTACK_IS_ACTIVE = 40;

  public Chupacabra() throws InvalidNameException {
    super("Chupacabra");
  }

  @Override
  public void attack(Hero hero) {
    if (hero.getLifepoints() <= HERO_LIFE_POINTS_BELOW_FIERCE_ATTACK_IS_ACTIVE) {
      fierceAttack(hero);
    } else {
      super.attack(hero);
    }
  }

  @Override
  protected void fierceAttack(Hero hero) {
      int currentHeroLifepoints = hero.getLifepoints();
      hero.setLifepoints(currentHeroLifepoints - (this.getAttack() * 2));
  }
}
