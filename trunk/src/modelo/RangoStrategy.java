package modelo;

public interface RangoStrategy {
	
	public abstract void viajarACiudad(Ciudad ciudadActual, Ciudad ciudadDestino);
	public abstract boolean esNovato();
	public abstract boolean esDetective();
	public abstract boolean esInvestigador();
	public abstract boolean esSargento();
	public abstract Pista pedirPista(Edificio edificio);
	public abstract boolean nivelDePistaCorrecto(Pista pista);
	public abstract int cantidadCiudadesRutaDeEscape();
	public abstract ObjetoRobado elegirObjetoRobado(String ciudad);
	public abstract boolean nivelObjetoRobadoCorrecto(ObjetoRobado objeto);
	
}
