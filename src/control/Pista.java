package control;

public class Pista {
	private String pista;

	public Pista(){
		this.pista = "No se vio a esa persona poc aca";
	}
	public Pista(String pist){
		this.pista = pist;
	}
	public void setPista(String pist) {
		this.pista = pist;
	}

	public String getPista() {
		return this.pista;
	}
}