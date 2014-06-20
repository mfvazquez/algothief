package modelo;

public class OrdenDeArresto {
	private String nombreLadron;
	
	public OrdenDeArresto(String nom){
		this.nombreLadron = nom;
	}
	
	public String getNombre(){
		return this.nombreLadron;
	}
}
