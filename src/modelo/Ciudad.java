package modelo;

import java.util.ArrayList;

public class Ciudad {
	private String nombre;
	private ArrayList<Edificio> edificios;
	private Coordenada coordenadas;
	private int edificiosVisitados;
	
	public Ciudad(String nom, int latitud, int longitud) {
		this.nombre = nom;
		this.edificios = new ArrayList<Edificio>();
		this.edificios.add(new Banco());
		this.edificios.add(new Aeropuerto());
		this.edificios.add(new Biblioteca());
		this.coordenadas = new Coordenada(latitud, longitud);
		this.edificiosVisitados = 0;
	}
	
	
/*	private LinkedList<Edificio> edificios;

	public void setEdificio(Edificio edi) {
		this.edificios.addLast(edi);
	}

	public Edificio getEdificioNro(int nro) {
		return this.edificios.get(nro);
	}*/

	public void setNombre(String nom) {
		this.nombre = nom;
	}

	public String getNombre() {
		return this.nombre;
	}

	// ESTO SE DEBERIA PEDIRSE AL MAPA
	public void obtenerDestinos(ArrayList<Ciudad> ciudadesDestino) {
		// TODO Auto-generated method stub
		Ciudad ciudad0 = new Ciudad("Chascomus", 1, 1);
		Ciudad ciudad1 = new Ciudad("Mar del Plata", 0, 1);
		Ciudad ciudad = new Ciudad("Buenos Aires", 2, 2);
		ciudadesDestino.add(ciudad0);
		ciudadesDestino.add(ciudad1);
		ciudadesDestino.add(ciudad);
	}

	public Edificio visitarEdificio(Policia policia, int edi) {
		this.edificiosVisitados += 1;
		policia.getMision().consumirTiempo(edificiosVisitados);
		return this.edificios.get(edi);
	}

	
	public double distancia(Ciudad ciudad){
		return this.coordenadas.distancia(ciudad.coordenadas);
	}

	public void generarPistas() {
		this.edificios.get(1).setPista(new Pista("Se fue en un avion con bandera azul y blanca"));
		this.edificios.get(0).setPista(new Pista("Tenia pelo rubio"));
		this.edificios.get(2).setPista(new Pista("Estuvo leyendo sobre la revolucion de mayo"));
		
	}

}
