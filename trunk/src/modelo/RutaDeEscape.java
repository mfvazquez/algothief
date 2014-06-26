package modelo;

import java.util.ArrayList;
import java.util.List;


public class RutaDeEscape {
	private ArrayList<Ciudad> ciudades;
	
	public RutaDeEscape(RangoStrategy rango) {
		ciudades = new ArrayList<Ciudad>();
		Ciudad actual = Mapa.getInstance().verCiudadInicial();
		
		for(int i = 0; i < rango.cantidadCiudadesRutaDeEscape(); i++){
			ciudades.add(actual);
			List<Ciudad> destinos = Mapa.getInstance().ciudadesDestino(actual);
			Double subindice = Math.floor(Math.random()*destinos.size());
			actual = destinos.get(subindice.intValue());
		}
		this.generarPistas(rango);
	}
	
	private void generarPistas(RangoStrategy rango){
		for(int i = 0; i < ciudades.size(); i++){
			Ciudad actual = ciudades.get(i);
			if (i == ciudades.size()-1){
				actual.generarPistas(ciudades.get(i), rango);
				// poner pistas de qeu el ladron esta en la ciudad
			}else{
				actual.generarPistas(ciudades.get(i+1), rango);
			}
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
	
	public void agregarLadron(Ladron ladron){
		Ciudad destino = ciudades.get(ciudades.size()-1);
		Edificio edificio = destino.getAeropuerto();
		edificio.setLadron(ladron);
		Pista pist = new PistaDificil();
		pist.setPista("Cuidado, estas muy serca");
		destino.getBanco().setPistaD(pist);
		destino.getBanco().setPistaF(pist);
		destino.getBanco().setPistaM(pist);
		destino.getBiblioteca().setPistaD(pist);
		destino.getBiblioteca().setPistaF(pist);
		destino.getBiblioteca().setPistaM(pist);
		
	}
}
