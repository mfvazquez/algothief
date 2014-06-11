package control;

import java.lang.String;
import control.Mision;

public class Policia {
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;

	private String rango;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = "novato";
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
	 
}
