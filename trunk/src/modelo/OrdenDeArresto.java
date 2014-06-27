package modelo;

public class OrdenDeArresto {
	private String nombreLadron;
	
	public OrdenDeArresto(){
		nombreLadron = "Orden no emitida";
	}
	
	public OrdenDeArresto(String nom){
		this.nombreLadron = nom;
	}
	
	public String getNombre(){
		return this.nombreLadron;
	}
}
