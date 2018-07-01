package junglesurvival.participants;


public class Animal extends Enemy {

  private static final int REGULAR_DAMAGE_PER_ATTACK = 1;
  private static final int ANIMAL_STARTING_LIFE_POINTS = 5;
  private static final int ANIMAL_GIVEN_EXPERIENCE = 1;
  private AnimalType animal;

  public Animal(AnimalType animal) {

    super(animal.getName());
    this.animal = animal;
    setGivenExperience(ANIMAL_GIVEN_EXPERIENCE);
    setAttack(REGULAR_DAMAGE_PER_ATTACK);
    setLifepoints(ANIMAL_STARTING_LIFE_POINTS);
  }

  private AnimalType getAnimalType() {
    return animal;
  }

  public void makeSound(){
    System.out.printf("I am %s and I can %s.\n", getName(), getAnimalType().getSound());
  }

  @Override
  public void attack(Hero hero) {
    int heroCurrentLifePoints = hero.getLifepoints();
    hero.setLifepoints(heroCurrentLifePoints - getAttack());
  }
}
