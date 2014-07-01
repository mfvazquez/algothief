package modelo;

public class PistaMedia extends Pista {
	
	public PistaMedia(String ciudad, String edificio) {
		super(ciudad, edificio, "pistasmedia");
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
