package modelo;

import java.util.ArrayList;
import java.util.List;


public class RutaDeEscape {
	private ArrayList<Ciudad> ciudades;
	
	public RutaDeEscape(Mapa mapa, int rango) {
		ciudades = new ArrayList<Ciudad>();
		Ciudad actual = mapa.verCiudadInicial();
		
		for(int i = 0; i < rango; i++){
			actual.generarPistas();
			ciudades.add(actual);
			List<Ciudad> destinos = mapa.ciudadesDestino(actual);
			Double subindice = Math.floor(Math.random()*destinos.size());
			actual = destinos.get(subindice.intValue());
		}
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
	
	public Ciudad getCiudad(int index){
		return ciudades.get(index);
	}
	
	public int size(){
		return ciudades.size();
	}
}
