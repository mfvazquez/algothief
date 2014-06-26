package modelo;

public class PistaFacil extends Pista {
	
	public PistaFacil(){
		super();
	}

	public PistaFacil(String edificio, String ciudad){
        this.pista = "del archivo";
	}
	
	public PistaFacil(String pista, String edificio, String ciudad){
		this.pista = pista;
		this.edificio = edificio;
		this.ciudad = ciudad;
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
