package junglesurvival.participants;

import junglesurvival.participants.Enemy;
import junglesurvival.participants.Hero;

import javax.rmi.PortableRemoteObject;

//TODO: override method concedeAttack to all monsters
public abstract class Monster extends Enemy {

    protected static final int REGULAR_DAMAGE_PER_ATTACK = 3;
    protected static final int MONSTER_STARTING_LIFE_POINTS = 15;
    protected static final int MONSTER_GIVEN_EXPERIENCE = 3;

    public Monster(String name) {
        super(name);
        setEnemylifePoints(MONSTER_STARTING_LIFE_POINTS);
        setDamagePerAttack(REGULAR_DAMAGE_PER_ATTACK);
        setGivenExperience(MONSTER_GIVEN_EXPERIENCE);
    }


    protected abstract void fight(Hero hero);

    protected abstract void fierceAttack(Hero hero);

  @Override
  public void attack(Hero hero) {
    if (this.getDamagePerAttack() > REGULAR_DAMAGE_PER_ATTACK){
      this.setDamagePerAttack(REGULAR_DAMAGE_PER_ATTACK);
    }
    hero.concedeAttack(this);
  }
}
