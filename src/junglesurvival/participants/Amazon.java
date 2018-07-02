package junglesurvival.participants;
import junglesurvival.Dice;
import junglesurvival.items.Item;
import junglesurvival.items.Weapon;
import junglesurvival.items.WeaponType;


public class Amazon extends Hero {

    private static final int AMAZON_LIFE_POINTS=150;
    private static final int AMAZON_ATTACK_POINTS=15;
    private static final int SPECIAL_ATTACK_BONUS=10;

    public Amazon(String name) {
        super(name);
        setLifepoints(AMAZON_LIFE_POINTS);
        setAttack(AMAZON_ATTACK_POINTS);
        setGender(Gender.FEMALE);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        Dice dice=new Dice();
        int diceValue=dice.getValue();
        int finalAttack=0;
        if (enemy instanceof Flyable) {
            if (getBag().stream().filter(item -> item instanceof Weapon).anyMatch(item -> ((Weapon) item).getType().equals(WeaponType.RANGE)))
                finalAttack = getAttack();
            else
                finalAttack = getAttack() / 2;
        }
//
//            for (Item item : getBag()) { //todo streamAPI this ?
//                if (item instanceof Weapon) {
//                    if (((Weapon) item).getType().equals(WeaponType.RANGE)) {
//                        finalAttack = getAttack();
//                        break;
//                    } else
//                        continue;
//
//                }
//            }
//            if(finalAttack==0)
//                finalAttack=getAttack()/2;
//        }
        else
            finalAttack=getAttack();


        if(diceValue>3) {
            if(diceValue==6)
                finalAttack = finalAttack+(SPECIAL_ATTACK_BONUS*2);
            else
                finalAttack+=SPECIAL_ATTACK_BONUS;
        }

        enemy.setLifepoints(enemy.getLifepoints() - finalAttack);

        if (enemy.getLifepoints() <= 0) setExperience(enemy.getGivenExperience());

    }
}
