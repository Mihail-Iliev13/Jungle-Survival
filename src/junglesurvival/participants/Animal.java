package junglesurvival.participants;


import junglesurvival.Exceptions.InvalidNameException;

public class Animal extends Enemy {

  private static final int REGULAR_DAMAGE_PER_ATTACK = 3;
  private static final int ANIMAL_STARTING_LIFE_POINTS = 10;
  private static final int ANIMAL_GIVEN_EXPERIENCE = 10;
  private AnimalType animalType;

  public Animal(AnimalType type) throws InvalidNameException {

    super(type.getName());
    this.animalType = type;
    setGivenExperience(ANIMAL_GIVEN_EXPERIENCE);
    setAttack(REGULAR_DAMAGE_PER_ATTACK);
    setLifepoints(ANIMAL_STARTING_LIFE_POINTS);
  }

  private AnimalType getAnimalType() {
    return animalType;
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
