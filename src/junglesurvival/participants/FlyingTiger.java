package junglesurvival.participants;

public class FlyingTiger extends Monster implements Flyable{
  private static final int HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED = 3;

  public FlyingTiger(String name) {
    super(name);

  }

  @Override
  protected void fierceAttack(Hero hero) {
    int currentDamage = this.getDamagePerAttack();
    this.setDamagePerAttack(currentDamage + 2);
  }

  @Override
  public void fight (Hero hero) {
    if(hero.getExperience() < HERO_LEVEL_BEYOND_WHICH_FIERCE_ATTACK_IS_ACTIVATED){
      fierceAttack(hero);
    } else {
      attack(hero);
    }
  }

  @Override
  void concedeAttack(Participant participant) {

  }

  @Override
  public void fly() {
    System.out.printf("The %s can fly! He is invulnerable to your your weapon!", this.getName());
  }
}
