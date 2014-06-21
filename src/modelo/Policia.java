package modelo;

import java.lang.String;

import modelo.Mision;

public class Policia {
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;
	private Mision mision;
	private int velocidad;
	private OrdenDeArresto orden;

	private int rango;
	private Juego juego;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = 3;
		velocidad = 1; // MODIFICAR LUEGO LA VELOCIDAD RESPECTO AL NIVEL
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public int cantidadMisionesResueltas() {
		return this.casosResueltos;
	}
	
	public void asignarMision(Mision m) {
		this.mision = m;
		this.ciudadActual = m.ciudadComienzo();
	}

//este metodo tal vez pueda removerse y usarse que el juego cree la mision
public Mision nuevaMision() {
    this.mision = new Mision(rango); 
    this.ciudadActual = mision.ciudadComienzo();
    return mision;
}
 	
 	public void viajarACiudad(Ciudad nuevaCiudad) {
 		//double distancia = this.ciudadActual.distancia(nuevaCiudad);
 		//Double demora = new Double(distancia/velocidad);
 		//this.mision.consumirTiempo(demora.intValue());
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
	
	public int getRango() {
		return rango;
	}
	
	public Mision getMision() {
		return this.mision;
	}
	
	public void misionResuelta(boolean atrapoLadron) {
		if (atrapoLadron) this.casosResueltos = this.casosResueltos +1;
	}
}
