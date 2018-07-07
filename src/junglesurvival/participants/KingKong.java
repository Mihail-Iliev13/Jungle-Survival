package junglesurvival.participants;

import junglesurvival.Exceptions.InvalidNameException;

public class KingKong extends Monster {

  private static final int HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_NO_LONGER_ACTIVE = 75;


  public KingKong() throws InvalidNameException {
    super("King Kong");
  }

  @Override
  public void attack(Hero hero) {
    if (hero.getLifepoints() >= HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_NO_LONGER_ACTIVE){
      this.fierceAttack(hero);
    } else {
      super.attack(hero);
    }
  }

  @Override
  protected void fierceAttack(Hero hero) {
    int currentHeroLifepoints = hero.getLifepoints();
    int acceleratedAttack = this.getAttack() + 1;
    hero.setLifepoints(currentHeroLifepoints - acceleratedAttack);
    this.setAttack(acceleratedAttack);
  }
}
