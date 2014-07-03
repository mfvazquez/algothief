package modelo;


public class RangoNovatoStrategy implements RangoStrategy {
	
	private int velocidad = 900;
	
	@Override
	public void viajarACiudad(Ciudad ciudadActual, Ciudad ciudadDestino) {
		double distancia = ciudadActual.distancia(ciudadDestino);
 		Double demora = new Double(distancia/velocidad);
 		Tiempo.getInstance().consumirTiempo(demora.intValue());
	}

	@Override
	public boolean esNovato() {
		return true;
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
		return false;
	}
	
	@Override
	public  Pista pedirPista(Edificio edificio){
		return edificio.obtenerPistaFacil();
	}

	@Override
	public boolean nivelDePistaCorrecto(Pista pista) {
		return pista.esPistaFacil();
	}
	
	@Override
	public int cantidadCiudadesRutaDeEscape() {
		return 4;
	}
	
	public ObjetoRobado elegirObjetoRobado(String ciudad) {
		return new ObjetoComun(ciudad);
	}
	
	@Override
	public boolean nivelObjetoRobadoCorrecto(ObjetoRobado objeto) {
		return objeto.esObjetoComun();
	}


}
