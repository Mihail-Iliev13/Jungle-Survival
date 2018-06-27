package junglesurvival.participants;

enum Gender {
    MALE, FEMALE
}

public class Hero extends Participant {
    private Gender gender;
    private int experience;
    private List<Item> bag;
    private List<Jewel> bribe;
    private int currentAttack;

}
