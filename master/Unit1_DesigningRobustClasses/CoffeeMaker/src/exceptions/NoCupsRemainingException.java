package exceptions;

public class NoCupsRemainingException extends Exception {
    public NoCupsRemainingException() {
        super("There are no cups to pour coffee into!");
    }
}
