package control;

public class Aeropuerto extends Edificio {
	private Ciudad ciudad;
	private Pista pista;
	
	public Aeropuerto(Ciudad c) {
		ciudad = c;
		pista = new Pista();
	}
	
	public Pista obtenerPista(Mision mision) {
	/* esto se tiene que hacer con el archivo, queda para después
	 * */
		
		if (mision.ladronEstaEnCiudad(this.ciudad)) {
			this.pista.setPista("Se fue en un auto con bandera azul, blanca y roja");
		}		
		return this.pista;
	}
}
