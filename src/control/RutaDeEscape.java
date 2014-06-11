package control;

import java.util.ArrayList;

public class RutaDeEscape {
	private ArrayList<Ciudad> ciudades;
	
	public RutaDeEscape(String rango) {
		this.ciudades = new ArrayList<Ciudad>( );
Ciudad ciudad = new Ciudad("Buenos Aires");
		(this.ciudades).add(ciudad);
	}
	
	public Ciudad ciudadComienzo() {
		return ciudades.get(0);
	}
}
