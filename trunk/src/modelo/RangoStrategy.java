package modelo;

public interface RangoStrategy {
	
	public abstract void viajarACiudad(Ciudad ciudadActual, Ciudad ciudadDestino);
	public abstract boolean esNovato();
	public abstract boolean esDetective();
	public abstract boolean esInvestigador();
	public abstract boolean esSargento();
	public abstract boolean nivelDePistaCorrecto(Pista pista);
	public abstract int cantidadCiudadesRutaDeEscape();
	public abstract boolean nivelObjetoRobadoCorrecto(ObjetoRobado objeto);
}
