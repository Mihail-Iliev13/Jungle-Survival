package junglesurvival.participants;

import junglesurvival.Items.Item;
import junglesurvival.Items.Jewel;

import java.util.List;

enum Gender {
    MALE, FEMALE
}

public class Hero extends Participant {
    private Gender gender;
    private int experience;
    private List<Item> bag;
    private List<Jewel> bribe;
    private int currentAttack;

    public Hero(String name, int lifepoints, int attack) {
        super(name, lifepoints, attack);
    }
}
