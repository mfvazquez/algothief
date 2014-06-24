package modelo;

public class RangoSargentoStrategy implements RangoStrategy {

	private int velocidad = 1500;
	
	@Override
	public void viajarACiudad(Ciudad ciudadActual, Ciudad ciudadDestino) {
		double distancia = ciudadActual.distancia(ciudadDestino);
 		Double demora = new Double(distancia/velocidad);
 		Tiempo.getInstance().consumirTiempo(demora.intValue());
	}

	@Override
	public boolean esNovato() {
		return false;
	}

	@Override
	public boolean esDetective() {
		return false;
	}

	@Override
	public boolean esInvestigador() {
		return false;
	}

	@Override
	public boolean esSargento() {
		return true;
	}

	@Override
	public  Pista pedirPista(Edificio edificio){
		return edificio.obtenerPistaDificil();
	}
	
	@Override
	public boolean nivelDePistaCorrecto(Pista pista) {
		return pista.esPistaDificil();
	}
	
	@Override
	public int cantidadCiudadesRutaDeEscape() {
		return 7;
	}
	
	@Override
	public boolean nivelObjetoRobadoCorrecto(ObjetoRobado objeto) {
		return objeto.esObjetoMuyValioso();
	}

}
