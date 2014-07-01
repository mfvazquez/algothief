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

	public void generarPistas(Ciudad destino, Ladron ladron) {
		String pistaLadron = null;
		if (Math.random()<0.5) {
			pistaLadron = ladron.getPista();
		}
		this.aeropuerto.setPistaF(new PistaFacil(destino.getNombre(),"aeropuerto", pistaLadron));
		this.aeropuerto.setPistaM(new PistaMedia(destino.getNombre(),"aeropuerto", pistaLadron));
		this.aeropuerto.setPistaD(new PistaDificil(destino.getNombre(),"aeropuerto", pistaLadron));
		pistaLadron = null;
		if (Math.random()<0.5) {
			pistaLadron = ladron.getPista();
		}
		this.banco.setPistaF(new PistaFacil(destino.getNombre(),"banco", pistaLadron));
		this.banco.setPistaM(new PistaMedia(destino.getNombre(),"banco", pistaLadron));
		this.banco.setPistaD(new PistaDificil(destino.getNombre(),"banco", pistaLadron));
		pistaLadron = null;
		if (Math.random()<0.5) {
			pistaLadron = ladron.getPista();
		}
		this.biblioteca.setPistaF(new PistaFacil(destino.getNombre(),"biblioteca", pistaLadron));
		this.biblioteca.setPistaM(new PistaMedia(destino.getNombre(),"biblioteca", pistaLadron));
		this.biblioteca.setPistaD(new PistaDificil(destino.getNombre(),"biblioteca", pistaLadron));
	}

}
