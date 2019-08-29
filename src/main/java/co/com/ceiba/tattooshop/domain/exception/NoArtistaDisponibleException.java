package co.com.ceiba.tattooshop.domain.exception;

public class NoArtistaDisponibleException extends RuntimeException {

	private static final long serialVersionUID = -117950943171362289L;

	public NoArtistaDisponibleException(String mensaje) {
		super(mensaje);
	}

}
