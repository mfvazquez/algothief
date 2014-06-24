package modelo;

public abstract class Edificio {
	protected Ciudad ciudad;
	protected String tipo;
	protected Ladron ladron;
	//private EdificioStrategy strategy;
	
	protected Pista pistaF;
	protected Pista pistaM;
	protected Pista pistaD;
	
	public Edificio(Ciudad c){
		ciudad = c;
		ladron = null;
		
		pistaF = new PistaFacil();
		pistaM = new PistaMedia();
		pistaD = new PistaDificil();
	}
	
	public Pista obtenerPistaFacil(){
		//PistaFacil pistaFacil = new PistaFacil(this.tipo, ladron.siguienteCiudadEnRuta(ciudad));
		return pistaF;
	}
	
	public Pista obtenerPistaMedia(){
		return pistaM;
	}
	
	public Pista obtenerPistaDificil(){
		return pistaD;
	}
	
	public void setPistaF(Pista pist) {
		this.pistaF = pist;
	}
	
	public void setPistaM(Pista pist) {
		this.pistaM = pist;
	}
	
	public void setPistaD(Pista pist) {
		this.pistaD = pist;
	}

	public void setLadron(Ladron ladri){
		ladron = ladri;
	}
	
	public boolean ladronEncontrado(){
		return ladron != null;
	}
	
	public Ladron getLadron(){
		return ladron;
	}
	
}
