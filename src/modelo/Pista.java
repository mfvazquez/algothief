package modelo;

public abstract class Pista {
	protected String pista;
	protected String ciudad;
	protected String edificio;

	public Pista(){
		this.pista = "No se vio a esa persona por aca";
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

	public abstract boolean esPistaFacil();
   	public abstract boolean esPistaMedia();
    public abstract boolean esPistaDificil();
    
   // public boolean esPistaDeEdificio(Edificio edi){
   // 	return (this.edificio.equals(edi.getTipo()));
   // }

}
