package junglesurvival.items;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

  public String getName(){
    return name;
  }

  public void printItem(){
    System.out.println(getName());
  }

    @Override
    public String toString() {//otherwise Hero.status printed strange things in the bag ;)
        return name;
    }
}
