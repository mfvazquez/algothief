package modelo;

public class RangoDetectiveStrategy implements RangoStrategy {

	private int velocidad = 1100;
	
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
		return true;
	}

	@Override
	public boolean esInvestigador() {
		return false;
	}

	@Override
	public boolean esSargento() {
		return false;
	}

	@Override
	public boolean nivelDePistaCorrecto(Pista pista) {
		return pista.esPistaMedia();
	}
	
	@Override
	public int cantidadCiudadesRutaDeEscape() {
		return 5;
	}
	
	@Override
	public boolean nivelObjetoRobadoCorrecto(ObjetoRobado objeto) {
		return objeto.esObjetoValioso();
	}

}
