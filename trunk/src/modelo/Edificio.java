package modelo;

public class Edificio {
	protected Ciudad ciudad;
	protected Pista pista;
	protected Ladron ladron;
	//private EdificioStrategy strategy;
	
	protected Pista pistaF;
	protected Pista pistaM;
	protected Pista pistaD;
	
	public Edificio(){
		pista = new PistaFacil();//POR AHORA LO DEJO ASI
		ladron = null;
		
		pistaF = new PistaFacil();
		pistaM = new PistaMedia();
		pistaD = new PistaDificil();
	}
	
	public Pista pedirPista() {
		return this.pista;
	}
	
	public Pista obtenerPistaFacil(){
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

	public void setPista(Pista pist) {
		this.pista = pist;
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
