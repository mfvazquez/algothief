package modelo;

public class PistaDificil extends Pista {
	
	public PistaDificil(String ciudad, String edificio, String pistaLadron) {
		super(ciudad, edificio, "pistasdificil", pistaLadron);
	}

	public PistaDificil() {
		super();
	}

	public boolean esPistaFacil() {
		return false;
	}
	 
	public boolean esPistaMedia() {
	  	return false;
	}
	public boolean esPistaDificil() {
	  	return true;
	}
	
}
