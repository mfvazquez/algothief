package control;

import java.util.ArrayList;

public class Ciudad {
	public String nombre;
	private Biblioteca biblio;
	private Aeropuerto puerto;
	private Banco banco;
	
	public Ciudad(String nom) {
		this.nombre = nom;
		this.biblio = new Biblioteca();
		this.puerto = new Aeropuerto(this);
		this.banco = new Banco();
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

	public void obtenerDestinos(ArrayList<Ciudad> ciudadesDestino) {
		// TODO Auto-generated method stub
Ciudad ciudad0 = new Ciudad("Chascomus");
Ciudad ciudad1 = new Ciudad("Mar del Plata");
Ciudad ciudad = new Ciudad("Buenos Aires");
		ciudadesDestino.add(ciudad0);
		ciudadesDestino.add(ciudad1);
		ciudadesDestino.add(ciudad);
	}

	public Aeropuerto visitarAeropuerto(Policia policia) {
		// TODO Auto-generated method stub
		return puerto;
	}

	public Biblioteca visitarBiblioteca(Policia policia) {
		// TODO Auto-generated method stub
		return biblio;
	}
	
	public Banco visitarBanco(Policia policia) {
		// TODO Auto-generated method stub
		return banco;
	}

}