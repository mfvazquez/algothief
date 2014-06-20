package control;

public class Biblioteca extends Edificio {
	
	private Pista pista;

	public Biblioteca(){
		this.pista = new Pista();
	}

	public Pista obtenerPista(Policia policia) {
	/* esto se tiene que hacer con el archivo, queda para después
	 * */
		Pista pista = new Pista();
		pista.setPista("Leyó sobre el imperio de Napoleón Bonaparte");
		return pista;
	}
}
