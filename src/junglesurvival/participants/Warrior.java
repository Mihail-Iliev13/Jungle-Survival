package junglesurvival.participants;

import junglesurvival.Dice;

public class Warrior extends Hero{

    private static final int WARRIOR_LIFE_POINTS=200;
    private static final int WARRIOR_ATTACK_POINTS=20;
    private static final int SPECIAL_ATTACK_BONUS=5;

    public Warrior(String name) {
        super(name, WARRIOR_LIFE_POINTS, WARRIOR_ATTACK_POINTS, Gender.MALE);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        Dice dice=new Dice();
        int diceValue=dice.getValue();
        int finalAttack=this.getAttack();

        if(diceValue>4)
            finalAttack+=SPECIAL_ATTACK_BONUS;


        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);

        if (enemy.getLifepoints() <= 0) setExperience(enemy.givenExperience);
    }
}