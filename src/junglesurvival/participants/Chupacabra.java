package junglesurvival.participants;

public class Chupacabra extends Monster {

  private static final int HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_ACTIVATED = 25;

  public Chupacabra(String name) {
    super(name);
  }

  @Override
  public void fight(Hero hero) {
    if (hero.getHeroLifePoints() <= HERO_LIFE_POINTS_WHERE_FIERCE_ATTACK_IS_ACTIVATED) {
      fierceAttack(hero);
    } else {
      attack(hero);
    }
  }

  @Override
  protected void fierceAttack(Hero hero) {
      int currentDamage = this.getDamagePerAttack();
      this.setDamagePerAttack(currentDamage * 2);
      hero.concedeAttack(this);
  }

  @Override
  void concedeAttack(Participant participant) {

  }
}
