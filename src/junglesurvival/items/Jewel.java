package junglesurvival.items;

public class Jewel extends Item {

//    private static final int RED_VALUE = 10;
//    private static final int BLUE_VALUE = 20;

//    private int value;
    private JewelColor color;

    public Jewel(String name, JewelColor color) {
        super(name);
        this.color = color;
//        setValue(color);
    }

//    public int getValue() {
//        return value;
//    }

//    private void setValue(JewelColor color) {
//        if(color.equals(JewelColor.BLUE))
//            this.value = BLUE_VALUE;
//        else if(color.equals(JewelColor.RED))
//            this.value = RED_VALUE;
//    }

    public JewelColor getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        return String.format("This is a %s jewel\n", getColor().toString().toLowerCase());
    }
}
