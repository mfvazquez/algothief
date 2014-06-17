package control;

import java.lang.String;

import control.Mision;

public class Policia {
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;
	Mision mision;
	int velocidad;

	private String rango;
	private Juego juego;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = "novato";
		velocidad = 1; // MODIFICAR LUEGO LA VELOCIDAD RESPECTO AL NIVEL
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public int cantidadMisionesResueltas() {
		return this.casosResueltos;
	}
	
 	public Mision nuevaMision() {
 		Mapa map = new Mapa("archivo inexistente");
	    this.mision = new Mision(map); 
	    this.ciudadActual = mision.ciudadComienzo();
	    return mision;
	}
 	
 	public void viajarACiudad(Ciudad nuevaCiudad) {
 		double distancia = this.ciudadActual.distancia(nuevaCiudad);
 		Tiempo tiempo = this.mision.getTiempo();
 		Double demora = new Double(distancia/velocidad);
 		tiempo.consumirTiempo(demora.intValue());
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
