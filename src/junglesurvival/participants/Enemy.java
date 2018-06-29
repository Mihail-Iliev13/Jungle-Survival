package junglesurvival.participants;

public abstract class Enemy extends Participant {
    private int givenExperience;
    private int enemylifePoints;
    protected int damagePerAttack;

    public Enemy(String name) {
        super(name);
    }

    public int getEnemylifePoints() {
        return enemylifePoints;
    }

    protected void setEnemylifePoints(int enemylifePoints) {
        this.enemylifePoints = enemylifePoints;
    }

    public int getGivenExperience() {
        return givenExperience;
    }

    protected void setGivenExperience(int givenExperience) {
        this.givenExperience = givenExperience;
    }

    public int getDamagePerAttack() {
        return damagePerAttack;
    }

    protected void setDamagePerAttack(int damagePerAttack) {
        this.damagePerAttack = damagePerAttack;
    }

    public abstract void attack(Hero hero);

}
