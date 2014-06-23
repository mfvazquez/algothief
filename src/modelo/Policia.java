package modelo;

import java.lang.String;

import modelo.Mision;

public class Policia{
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;
	private Mision mision;
	private int velocidad;
	private OrdenDeArresto orden;
	private RangoStrategy rango;
	private Ladron capturado;
	private int edificiosVisitados;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = new RangoNovatoStrategy();
		velocidad = 900; // MODIFICAR LUEGO LA VELOCIDAD RESPECTO AL NIVEL
		capturado = null;
		ciudadActual = null;
		edificiosVisitados = 0;
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public int cantidadMisionesResueltas() {
		return this.casosResueltos;
	}
	
	public void asignarMision(Mision m) {
		this.mision = m;
		this.asignarCiudad(m.ciudadComienzo());
	}
	
	public void asignarCiudad(Ciudad city){
		ciudadActual = city;
	}
	
	public boolean ciudadAsignada(){
		return ciudadActual != null;
	}
 	
 	public void viajarACiudad(Ciudad nuevaCiudad){
 	/*	if (ciudadActual == null){
 			ciudadActual = nuevaCiudad;
 		}else{
	 		double distancia = this.ciudadActual.distancia(nuevaCiudad);
	 		Double demora = new Double(distancia/velocidad);
	 		Tiempo.getInstance().consumirTiempo(demora.intValue());
	 		this.ciudadActual = nuevaCiudad;
	 	}*/
 		
 		this.rango.viajarACiudad(this.ciudadActual, nuevaCiudad);
 		this.ciudadActual = nuevaCiudad;
 		
 		edificiosVisitados = 0;
 	}
 	
 	public Ciudad obtenerCiudadActual() {
 		return this.ciudadActual;
 	}
	
	public RangoStrategy getRango() {
		return rango;
	}
	
	public Mision getMision() {
		return this.mision;
	}
	
	public void misionResuelta(boolean atrapoLadron) {
		if (atrapoLadron) this.casosResueltos = this.casosResueltos +1;
	}
	
	@Override
	public boolean equals(Object objeto){
		Policia otro = (Policia) objeto;
		return this.nombre.equals(otro.nombre);
	}
	
	public Pista visitarEdificio(Edificio edificio){
		if (edificiosVisitados < 3){
			edificiosVisitados = edificiosVisitados + 1;
		}
		Tiempo.getInstance().consumirTiempo(edificiosVisitados);
		if (edificio.ladronEncontrado()){
			this.capturar(edificio.getLadron());
			return null;
		}
		return edificio.pedirPista();
	}
	
	public void capturar(Ladron ladron){
		// el ladron debe disparar o hacer algo, consumir tiempo y luego verificar que sea el mismo ladron que la orden de arrestro
		// y almacenar al ladron en el atributo ladron capturado del policia
		capturado = ladron;
	}
	
	public boolean ladronCapturado(){
		return capturado != null;
	}
	
}
