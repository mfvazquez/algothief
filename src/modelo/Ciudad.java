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
		
		Pista pistaF = new PistaFacil();
		pistaF.setPista("Se fue en un avion con bandera azul y blanca");
		this.aeropuerto.setPista(pistaF);
		pistaF.setPista("Tenia pelo rubio");
		this.banco.setPista(pistaF);
		pistaF.setPista("Estuvo leyendo sobre la revolucion de mayo");
		this.biblioteca.setPista(pistaF);
		
		Pista pistaM = new PistaMedia();
		//setear para edificios
		Pista pistaD = new PistaDificil();
		//setear para edificios
		
		
		
		
		if (rango.nivelDePistaCorrecto(new PistaFacil())) {
			// if (rango.esNovato())
			Pista pista = new PistaFacil();
			pista.setPista("Se fue en un avion con bandera azul y blanca");
			this.aeropuerto.setPista(pista);
			pista.setPista("Tenia pelo rubio");
			this.banco.setPista(pista);
			pista.setPista("Estuvo leyendo sobre la revolucion de mayo");
			this.biblioteca.setPista(pista);
		}
		else {
			if (rango.nivelDePistaCorrecto(new PistaMedia())) {
				
			}
			else {
				if (rango.nivelDePistaCorrecto(new PistaDificil())){
					
				}
			}
		}
	}

}
