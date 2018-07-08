package junglesurvival.participants;


import junglesurvival.exceptions.InvalidNameException;

public class Animal extends Enemy {

  private static final int REGULAR_DAMAGE_PER_ATTACK = 3;
  private static final int ANIMAL_STARTING_LIFE_POINTS = 10;
  private static final int ANIMAL_GIVEN_EXPERIENCE = 10;
  private AnimalType animalType;

  public Animal(AnimalType type) throws InvalidNameException {

    super(type.getName(), ANIMAL_STARTING_LIFE_POINTS, REGULAR_DAMAGE_PER_ATTACK, ANIMAL_GIVEN_EXPERIENCE);
    this.animalType = type;
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
