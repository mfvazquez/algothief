package control;

import java.lang.String;

import control.Mision;

public class Policia {
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;

	private String rango;
	private Juego juego;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = "novato";
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public int cantidadMisionesResueltas() {
		return this.casosResueltos;
	}
	
 	public Mision nuevaMision() { 
	    Mision mision = new Mision(this.rango); 
	    this.ciudadActual = mision.ciudadComienzo();
	    return mision;
	}
 	
 	public void viajarACiudad(Ciudad nuevaCiudad) {
 		this.ciudadActual = nuevaCiudad;
 	}
 	
 	public Ciudad obtenerCiudadActual() {
 		return this.ciudadActual;
 	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego jue) {
		
		this.juego = jue;
	}
	 
}
