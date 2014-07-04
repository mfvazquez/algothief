package modelo;

public class ArchivoFaltante extends Exception {
	private static final long serialVersionUID = 1L;

	public ArchivoFaltante(String message) {
        super(message);
    }
}
