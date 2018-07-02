package junglesurvival;

import java.util.Random;

public class Dice {

  private int value;

  public int getValue() {
    Random rand = new Random();
    return rand.nextInt(6) + 1;
  }

  public int getValue(int diceSides) {
    Random rand = new Random();
    return rand.nextInt(diceSides) + 1;
  }
}
