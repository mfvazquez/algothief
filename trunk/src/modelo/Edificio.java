package modelo;

public class Edificio {
	private Pista pista;
	//private EdificioStrategy strategy;
	
	
	public Edificio(){
		pista = new Pista();
	}

	public void setPista(Pista pist) {
		this.pista = pist;
	}

	public Pista pedirPista() {
		return this.pista;
	}

}
