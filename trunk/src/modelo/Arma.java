package modelo;

public class Arma {
	private Integer demora;
	private String nombre;
	
	public Arma(String n, Integer d){
		demora = d;
		nombre = n;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public Integer getDemora(){
		return demora;
	}
}
