package co.com.ceiba.tattooshop.domain.exception;

public class NoServiceException extends RuntimeException {

	private static final long serialVersionUID = -5264937336895247597L;

	public NoServiceException(String message) {
		super(message);
	}

}
