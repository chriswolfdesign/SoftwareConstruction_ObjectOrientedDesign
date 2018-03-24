package exceptions;

public class TooManyBeansException extends BeansAmountException {
	public TooManyBeansException(double beans) {
		super(beans, beans + " is too many beans.");
		this.beans = beans;
	}
}
