package modelo;

public class PistaFacil extends Pista {
	
	public PistaFacil(){
		super();
	}

	public PistaFacil(String ciudad, String edificio){
        super(ciudad, edificio, "pistasfacil");
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
