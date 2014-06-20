package control;

import java.lang.Math;

public class Coordenada {
	private int latitud;
	private int longitud;
	
	public Coordenada(int ancho, int alto){
		this.latitud = ancho;
		this.longitud = alto;
	}
	
	public double distancia(Coordenada otra_coordenada){
		int x = this.latitud - otra_coordenada.latitud;
		int y = this.longitud - otra_coordenada.longitud;
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}
}
