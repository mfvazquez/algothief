package modelo;

public class Edificio {
	private Pista pista;
	private Ladron ladron;
	//private EdificioStrategy strategy;
	
	
	public Edificio(){
		pista = new PistaFacil();//POR AHORA LO DEJO ASI
		ladron = null;
	}

	public void setPista(Pista pist) {
		this.pista = pist;
	}

	public Pista pedirPista() {
		return this.pista;
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
