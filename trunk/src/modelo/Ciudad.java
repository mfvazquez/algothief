package modelo;

import java.util.ArrayList;

public class Ciudad {
	private String nombre;
	private Banco banco;
	private Aeropuerto aeropuerto;
	private Biblioteca biblioteca;
	
	// private ArrayList<Edificio> edificios;
	
	private Coordenada coordenadas;
	private int edificiosVisitados;
	
	public Ciudad(String nom, int latitud, int longitud) {
		this.nombre = nom;
		
		this.aeropuerto = new Aeropuerto();
		this.biblioteca = new Biblioteca();
		this.banco = new Banco();
		
		//this.edificios = new ArrayList<Edificio>();
		//this.edificios.add(new Banco());
		//this.edificios.add(new Aeropuerto());
		//this.edificios.add(new Biblioteca());
		
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
	
	public Edificio getBanco(){
		return this.banco;
	}
	
	public Edificio getAeropuerto(){
		return this.aeropuerto;
	}
	
	public Edificio getBiblioteca(){
		return this.biblioteca;
	}
	
//	public Edificio visitarEdificio(Policia policia, int edi) {
//		this.edificiosVisitados += 1;
//		policia.getMision().consumirTiempo(edificiosVisitados);
//		return this.edificios.get(edi);
//	}

	
	public double distancia(Ciudad ciudad){
		return this.coordenadas.distancia(ciudad.coordenadas);
	}

	public void generarPistas(Ciudad destino) {
		this.aeropuerto.setPista(new Pista("Se fue en un avion con bandera azul y blanca"));
		this.banco.setPista(new Pista("Tenia pelo rubio"));
		this.biblioteca.setPista(new Pista("Estuvo leyendo sobre la revolucion de mayo"));
	}

}
