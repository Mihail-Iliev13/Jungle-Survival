package junglesurvival.participants;

public enum AnimalType {

  LION("lion", "roar"), ELEPHANT("elephant", "trumpet"), MONKEY("monkey", "gibber");

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
