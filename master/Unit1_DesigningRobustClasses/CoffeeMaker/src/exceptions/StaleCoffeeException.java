package exceptions;

public class StaleCoffeeException extends Exception {
    private int minutes;

    public StaleCoffeeException(int minutes) {
        super("Coffee has not been brewed in " + minutes + " minutes!");
        this.minutes = minutes;
    }
}
