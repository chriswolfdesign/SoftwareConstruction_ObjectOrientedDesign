package exceptions;

public class BeansAmountException extends Exception {
    protected double beans;

    public BeansAmountException(double beans) {
        super(beans + " is not the right amount of beans.");
        this.beans = beans;
    }

	protected BeansAmountException(double beans, String message) {
		super(message);
		this.beans = beans;
	}

    // GETTERS
    public double getBeans() {
        return this.beans;
    }
}
