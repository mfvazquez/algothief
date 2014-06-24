package modelo;

import java.util.*;

public class Juego {
	private ArrayList<Policia> policias;
	
	public Juego(){
		policias = new ArrayList<Policia>();
	    Ladrones.getInstance();
	    Mapa.getInstance();
	}
	
	public boolean policiaExistente(Policia poli){
		return policias.contains(poli);
	}
	
	public void agregarPolicia(Policia poli) {
		if (!policias.contains(poli)){
			policias.add(poli);
		}
	}
		
	public int cantidadPolicias(){
		return policias.size();
	}
	
	public Policia obtenerPolicia(String nombre){
		Policia poli_aux = new Policia(nombre);
		if (!this.policiaExistente(poli_aux)) return null;
		int indice = policias.indexOf(poli_aux);
		return policias.get(indice);
	}

	
	public Mision nuevaMision(Policia policia) {
		Ladron ladron = Ladrones.getInstance().ladronAleatorio();
		Mision mision = new Mision(policia, ladron); 
	    policia.asignarMision(mision);
	    return mision;
	}
}
