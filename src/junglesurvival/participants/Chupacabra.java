package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public class Chupacabra extends Monster {

  private static final int HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_ACTIVATED = 25;

  public Chupacabra() throws InvalidNameException {
    super("Chupacabra");
  }

  @Override
  public void attack(Hero hero) {
    if (hero.getLifepoints() <= HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_ACTIVATED) {
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
