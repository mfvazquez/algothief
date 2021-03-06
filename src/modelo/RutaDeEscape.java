package modelo;

import java.util.ArrayList;
import java.util.List;


public class RutaDeEscape {
	private ArrayList<Ciudad> ciudades;
	
	public RutaDeEscape(RangoStrategy rango, Ladron ladron) {
		ciudades = new ArrayList<Ciudad>();
		Ciudad actual;
		try {
			actual = Mapa.getInstance().verCiudadInicial();
			for(int i = 0; i < rango.cantidadCiudadesRutaDeEscape(); i++){
				ciudades.add(actual);
				List<Ciudad> destinos;
				try {
					destinos = Mapa.getInstance().ciudadesDestino(actual);
					Double subindice = Math.floor(Math.random()*destinos.size());
					actual = destinos.get(subindice.intValue());
				} catch (MapaSeQuedoSinCiudades e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.generarPistas(ladron);
		} catch (ArchivoFaltante e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void generarPistas(Ladron ladron){
		for(int i = 0; i < ciudades.size(); i++){
			Ciudad actual = ciudades.get(i);
			if (i == ciudades.size()-1){
				actual.generarPistas(ciudades.get(i), ladron);
				// poner pistas de qeu el ladron esta en la ciudad
			}else{
				actual.generarPistas(ciudades.get(i+1), ladron);
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
		pist.setPista("Cuidado, estas muy cerca!");
		destino.getBanco().setPistaD(pist);
		destino.getBanco().setPistaF(pist);
		destino.getBanco().setPistaM(pist);
		destino.getBiblioteca().setPistaD(pist);
		destino.getBiblioteca().setPistaF(pist);
		destino.getBiblioteca().setPistaM(pist);
		
	}
}
