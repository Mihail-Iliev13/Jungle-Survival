package junglesurvival.participants;

public enum AnimalType {

  LION("Lion", "roar"), ELEPHANT("Elephant", "trumpet"), MONKEY("Monkey", "gibber");

  private String name;
  private String sound;

  AnimalType(String name, String sound){
    this.name = name;
    this.sound = sound;
  }

   public String getName() {
    return name;
  }

   String getSound() {
    return sound;
  }
}
