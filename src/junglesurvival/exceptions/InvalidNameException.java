package junglesurvival.exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
    }

    public String getMessage() {
        return "Invaid Name";
    }

    public void terminate(){
        System.exit(0);
    }

    public void printMessage() {
        System.out.println(this.getMessage());
    }
}
