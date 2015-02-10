package senha.core;

@SuppressWarnings("serial")
public class CaractereInvalidoException extends Exception {
	public CaractereInvalidoException() {
		super();
	}
	
	public CaractereInvalidoException(String message) {
		super(message);
	}
}
