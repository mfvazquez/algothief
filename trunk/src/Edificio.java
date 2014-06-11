package tpfinalalgo3;

public abstract class Edificio {
	private Pista pista;
	
	public void setPista(Pista pist){
		this.pista = pist;
	}
	public Pista pedirPista(){
		return this.pista;
	}

}
