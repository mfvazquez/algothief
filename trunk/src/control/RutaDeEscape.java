package control;

import java.util.ArrayList;

public class RutaDeEscape {
	private ArrayList<Ciudad> ciudades;
	
	public RutaDeEscape(String rango) {
//Tiene que ser aleatorio, con el mapa o archivo
		this.ciudades = new ArrayList<Ciudad>( );
Ciudad ciudad = new Ciudad("Buenos Aires");
Ciudad ciudad0 = new Ciudad("Chascomus");
Ciudad ciudad1 = new Ciudad("Bahia Blanca");
Ciudad ciudad2 = new Ciudad("Villa Gesell");
		(this.ciudades).add(ciudad);
		(this.ciudades).add(ciudad0);
		(this.ciudades).add(ciudad1);
		(this.ciudades).add(ciudad2);
	}
	
	public Ciudad ciudadComienzo() {
		return ciudades.get(0);
	}
	
	public boolean ciudadEnRuta(Ciudad c){
		String nombre = c.getNombre();
		for (int i=0; i<ciudades.size(); i++){
			if ((ciudades.get(i)).getNombre() == nombre) return true;
		};
		return false;
	}
}
