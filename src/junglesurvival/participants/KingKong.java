package junglesurvival.participants;

public class KingKong extends Monster {

  private static final int HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_NO_LONGER_ACTIVE = 75;


  public KingKong(String name) {
    super(name);
  }

  @Override
  public void fight(Hero hero) {
    if (hero.getHeroLifePoints() >= HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_NO_LONGER_ACTIVE){
      this.fierceAttack(hero);
    } else {
      attack(hero);
    }
  }

  @Override
  protected void fierceAttack(Hero hero) {
    int currentDamage = this.damagePerAttack;
    setDamagePerAttack(damagePerAttack + 1);
    hero.concedeAttack(this);
  }

  @Override
  void concedeAttack(Participant participant) {

  }
}
