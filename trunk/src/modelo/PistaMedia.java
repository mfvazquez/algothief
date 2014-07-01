package modelo;

public class PistaMedia extends Pista {
	
	public PistaMedia(String ciudad, String edificio, String pistaLadron) {
		super(ciudad, edificio, "pistasmedia", pistaLadron);
	}

	public PistaMedia() {
		super();
	}

	public boolean esPistaFacil() {
		return false;
	}
	 
	public boolean esPistaMedia() {
	 	return true;
	}
	
	public boolean esPistaDificil() {
	  	return false;
	}
	
}
