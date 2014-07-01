package modelo;

public class Ciudad {
	private String nombre;
	private Banco banco;
	private Aeropuerto aeropuerto;
	private Biblioteca biblioteca;	
	private Coordenada coordenadas;

	
	public Ciudad(String nom, double latitud, double longitud) {
		this.nombre = nom;
		this.aeropuerto = new Aeropuerto(this);
		this.biblioteca = new Biblioteca(this);
		this.banco = new Banco(this);		
		this.coordenadas = new Coordenada(latitud, longitud);

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
	
	@Override
	public boolean equals(Object objeto){
		Ciudad ciudad = (Ciudad) objeto;
		if (nombre == ciudad.nombre) return true;
		return false;
	}

	public void generarPistas(Ciudad destino, RangoStrategy rango) {
//actualmente se cargan las pistas antes
//después podría cambiarlo para que se carguen cuando se pidan
		this.aeropuerto.setPistaF(new PistaFacil(destino.getNombre(),"aeropuerto"));
		this.aeropuerto.setPistaM(new PistaMedia(destino.getNombre(),"aeropuerto"));
		this.aeropuerto.setPistaD(new PistaDificil(destino.getNombre(),"aeropuerto"));
		
		this.banco.setPistaF(new PistaFacil(destino.getNombre(),"banco"));
		this.banco.setPistaM(new PistaMedia(destino.getNombre(),"banco"));
		this.banco.setPistaD(new PistaDificil(destino.getNombre(),"banco"));
		
		this.biblioteca.setPistaF(new PistaFacil(destino.getNombre(),"biblioteca"));
		this.biblioteca.setPistaM(new PistaMedia(destino.getNombre(),"biblioteca"));
		this.biblioteca.setPistaD(new PistaDificil(destino.getNombre(),"biblioteca"));
		
		/*Pista pistaFA = new PistaFacil();
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
		this.biblioteca.setPistaD(pistaDBi);*/
		
	}

}
