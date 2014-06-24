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
		this.aeropuerto = new Aeropuerto();
		this.biblioteca = new Biblioteca();
		this.banco = new Banco();		
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
		Pista pistaF = new PistaFacil();
		pistaF.setPista("Se fue en un avion con bandera azul y blanca");
		this.aeropuerto.setPista(pistaF);
		pistaF.setPista("Tenia pelo rubio");
		this.banco.setPista(pistaF);
		pistaF.setPista("Estuvo leyendo sobre la revolucion de mayo");
		this.biblioteca.setPista(pistaF);
		
		Pista pistaM = new PistaMedia();
		pistaM.setPista("Se fue en un avion con bandera azul y blanca");
		this.aeropuerto.setPista(pistaM);
		pistaM.setPista("Tenia pelo rubio");
		this.banco.setPista(pistaM);
		pistaM.setPista("Estuvo leyendo sobre la revolucion de mayo");
		this.biblioteca.setPista(pistaM);
		
		Pista pistaD = new PistaDificil();
		pistaD.setPista("Se fue en un avion con bandera azul y blanca");
		this.aeropuerto.setPista(pistaD);
		pistaD.setPista("Tenia pelo rubio");
		this.banco.setPista(pistaD);
		pistaD.setPista("Estuvo leyendo sobre la revolucion de mayo");
		this.biblioteca.setPista(pistaD);
		
	}

}
