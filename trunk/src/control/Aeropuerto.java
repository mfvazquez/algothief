package control;

public class Aeropuerto extends Edificio {
	private Ciudad ciudad;
	
	public Aeropuerto(Ciudad c) {
		ciudad = c;
	}
	
	public Pista obtenerPista(Mision mision) {
	/* esto se tiene que hacer con el archivo, queda para después
	 * */
		Pista pista = new Pista();
		if (mision.ladronEstaEnCiudad(this.ciudad)) {
			pista.setPista("Se fue en un auto con bandera azul, blanca y roja");
		}
		else pista.setPista("Aca no es");		
		return pista;
	}
}
