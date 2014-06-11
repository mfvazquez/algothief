package control;

import java.lang.String;

public class Policia {
	public String nombre;
	private int casosResueltos;

	// private Rango rango;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		// rango = novato;
	}

	public int cantidadMisionesResueltas() {
		return this.casosResueltos;
	}

	/*
	 * public Mision nuevaMision() { return new Mision(rango); }
	 */
}
