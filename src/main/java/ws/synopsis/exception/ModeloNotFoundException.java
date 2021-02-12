package ws.synopsis.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ModeloNotFoundException extends RuntimeException {
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
