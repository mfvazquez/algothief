package modelo;

public class PistaFacil extends Pista {
	
	public PistaFacil(){
		super();
	}

	public PistaFacil(String ciudad, String edificio, String pistaLadron){
        super(ciudad, edificio, "pistasfacil", pistaLadron);
	}
	
	public boolean esPistaFacil() {
	 	return true;
	}
	 
	public boolean esPistaMedia() {
	  	return false;
	}
	
	public boolean esPistaDificil() {
	   	return false;
	}
}
