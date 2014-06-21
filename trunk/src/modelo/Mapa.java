package modelo;

import java.util.List;

public class Mapa {
	private Arbol<Ciudad> arbol;
	private static Mapa INSTANCE = null;
	
	private Mapa(){
		this.cargarCiudades();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Mapa();
	    }
	}

	public static Mapa getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	
	private void cargarCiudades(){
		
		//ESTE METODO DEBERIA LEER LAS CIUDADES CON SUS COORDENADAS DE UN XML
		
		Ciudad raiz = new Ciudad("Buenos Aires", 0, 0);
		
		Ciudad hijo1 = new Ciudad("Berlin", 1, 0);
		Ciudad hijo2 = new Ciudad("Tokio", 2, 0);
		
		Ciudad hijo11 = new Ciudad("Hong Kong", 0, 3);
		Ciudad hijo12 = new Ciudad("Nueva Delhi", 0, 4);
		
		Ciudad hijo21 = new Ciudad("Roma", 1, 5);
		Ciudad hijo22 = new Ciudad("Paris", 5, 1);
		
		Ciudad hijo111 = new Ciudad("Barcelona", 2, 4);
		Ciudad hijo112 = new Ciudad("Washington", 1, 3);
		Ciudad hijo113 = new Ciudad("Viena", 1, 6); 
		
		Ciudad hijo121 = new Ciudad("Bruselas", 5, 3);
		Ciudad hijo122 = new Ciudad("Minsk", 10, 2);
		
		Ciudad hijo211 = new Ciudad("Pretoria", 20, 30);
		Ciudad hijo212 = new Ciudad("Praga", 40, 10);
		
		Ciudad hijo221 = new Ciudad("Kiev", 20, 0);
		Ciudad hijo222 = new Ciudad("Bucarest", 10, 0);
		Ciudad hijo223 = new Ciudad("Atenas", 50, 50);
		
		arbol = new Arbol<Ciudad>(raiz);
		arbol.agregarHijo(raiz, hijo1);
		arbol.agregarHijo(raiz, hijo2);
		arbol.agregarHijo(hijo1, hijo11);
		arbol.agregarHijo(hijo1, hijo12);
		arbol.agregarHijo(hijo2, hijo21);
		arbol.agregarHijo(hijo2, hijo22);
		arbol.agregarHijo(hijo11, hijo111);
		arbol.agregarHijo(hijo11, hijo112);
		arbol.agregarHijo(hijo11, hijo113);
		arbol.agregarHijo(hijo12, hijo121);
		arbol.agregarHijo(hijo12, hijo122);
		arbol.agregarHijo(hijo21, hijo211);
		arbol.agregarHijo(hijo21, hijo212);
		arbol.agregarHijo(hijo22, hijo221);
		arbol.agregarHijo(hijo22, hijo222);
		arbol.agregarHijo(hijo22, hijo223);
	}
	
	public Ciudad ciudadAnterior(Ciudad ciudad){
		return arbol.verPadre(ciudad);
	}
	
	public List<Ciudad> ciudadesDestino(Ciudad ciudad){
		return arbol.verHijos(ciudad);
	}
		
	public List<Ciudad> ciudadesAdyacentes(Ciudad ciudad){
		List<Ciudad> adyacentes = arbol.verHijos(ciudad);
		if (adyacentes == null) return null;
		Ciudad anterior = arbol.verPadre(ciudad);
		if (anterior != null) adyacentes.add(anterior);
		return adyacentes;
	}
	
	public Ciudad verCiudadInicial() {
		return arbol.verRaiz();
	}
}
