package modelo;

import java.lang.Math;

public class Coordenada {
	private double latitud;
	private double longitud;
	
	public Coordenada(double ancho, double alto){
		this.latitud = ancho;
		this.longitud = alto;
	}
	
	public double distancia(Coordenada otra_coordenada){
		double x = this.latitud - otra_coordenada.latitud;
		double y = this.longitud - otra_coordenada.longitud;
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}
}
