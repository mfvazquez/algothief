package modelo;

import java.util.*;

public class Juego {
	private ArrayList<Ladron> ladrones;
	private ArrayList<Policia> policias;
	
	public Juego(){
		policias = new ArrayList<Policia>();
		ladrones= new ArrayList<Ladron>();
	    Ladron ladron1 = new Ladron();
	    ladron1.setNombre("Nick");
	    ladron1.setSexo("masculino");
	    ladron1.setHobby("Alpinismo");
	    ladron1.setCabello("negro");
	    ladron1.setSenia("anillo");
	    ladron1.setVehiculo("moto");
	    Ladron ladron2 = new Ladron();
	    ladron2.setNombre("Scar");
	    ladron2.setSexo("masculino");
	    ladron2.setHobby("croquet");
	    ladron2.setCabello("rojo");
	    ladron2.setSenia("anillo");
	    ladron2.setVehiculo("limusina");
	    Ladron ladron3 = new Ladron();
	    ladron3.setNombre("Carmen");
	    ladron3.setSexo("femenino");
	    ladron3.setHobby("tenis");
	    ladron3.setCabello("marron");
	    ladron3.setSenia("joyas");
	    ladron3.setVehiculo("convertible");
	    ladrones.add(ladron1);
	    ladrones.add(ladron1);
	    ladrones.add(ladron3);
	    
	    Mapa.getInstance();
	}
	
	public ArrayList<Ladron> getLadrones(){
		return ladrones;
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
	
	private Ladron ladronAleatorio(){
		Double subindice = Math.random()*ladrones.size();
		return ladrones.get(subindice.intValue());
	}
	
	public Mision nuevaMision(Policia policia) {
		Ladron ladron = this.ladronAleatorio();
		Mision mision = new Mision(policia, ladron); 
	    policia.asignarMision(mision);
	    return mision;
	}
}
