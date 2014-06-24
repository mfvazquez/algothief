package modelo;

public class Ciudad {
	private String nombre;
	private Banco banco;
	private Aeropuerto aeropuerto;
	private Biblioteca biblioteca;	
	private Coordenada coordenadas;
	private int edificiosVisitados;
	
	public Ciudad(String nom, double latitud, double longitud) {
		this.nombre = nom;
		this.aeropuerto = new Aeropuerto(this);
		this.biblioteca = new Biblioteca(this);
		this.banco = new Banco(this);		
		this.coordenadas = new Coordenada(latitud, longitud);
		this.edificiosVisitados = 0;
	}
	
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
		
	public double distancia(Ciudad ciudad){
		return this.coordenadas.distancia(ciudad.coordenadas);
	}

	public void generarPistas(Ciudad destino, RangoStrategy rango) {
//actualmente se cargan las pistas antes
//después podría cambiarlo para que se carguen cuando se pidan
		Pista pistaFA = new PistaFacil();
		pistaFA.setPista("Se fue en un avion con bandera azul y blanca");
		this.aeropuerto.setPistaF(pistaFA);
		Pista pistaFB = new PistaFacil();
		pistaFB.setPista("Tenia pelo rubio");
		this.banco.setPistaF(pistaFB);
		Pista pistaFBi = new PistaFacil();
		pistaFBi.setPista("Estuvo leyendo sobre la revolucion de mayo");
		this.biblioteca.setPistaF(pistaFBi);
		
		Pista pistaMA = new PistaMedia();
		pistaMA.setPista("Se fue en un avion con bandera azul y blanca(media)");
		this.aeropuerto.setPistaM(pistaMA);
		Pista pistaMB = new PistaMedia();
		pistaMB.setPista("Tenia pelo rubio(media)");
		this.banco.setPistaM(pistaMB);
		Pista pistaMBi = new PistaMedia();
		pistaMBi.setPista("Estuvo leyendo sobre la revolucion de mayo(media)");
		this.biblioteca.setPistaM(pistaMBi);
		
		Pista pistaDA = new PistaDificil();
		pistaDA.setPista("Se fue en un avion con bandera azul y blanca(dificil)");
		this.aeropuerto.setPistaD(pistaDA);
		Pista pistaDB = new PistaDificil();
		pistaDB.setPista("Tenia pelo rubio(dificil)");
		this.banco.setPistaD(pistaDB);
		Pista pistaDBi = new PistaDificil();
		pistaDBi.setPista("Estuvo leyendo sobre la revolucion de mayo(dificil)");
		this.biblioteca.setPistaD(pistaDBi);
		
	}

}
