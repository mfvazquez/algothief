package modelo;

import java.lang.String;
import java.util.ArrayList;

import modelo.Mision;

public class Policia{
	public String nombre;
	private int casosResueltos;
	private Ciudad ciudadActual;
	private Mision mision;
	private OrdenDeArresto orden;
	private RangoStrategy rango;
	private Ladron capturado;
	private int edificiosVisitados;

	public Policia(String n) {
		nombre = n;
		casosResueltos = 0;
		rango = new RangoNovatoStrategy();
		capturado = null;
		ciudadActual = null;
		edificiosVisitados = 0;
		orden = new OrdenDeArresto();
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
			return this.capturar(edificio.getLadron());
			
		}
		return rango.pedirPista(edificio);
	}
	
	public Pista capturar(Ladron ladron){
		Pista pist = new PistaFacil();
		
		if (this.orden.getNombre().equals(ladron.getNombre())){
			capturado = ladron;
			pist.setPista("Atrapaste al ladron: " + ladron.getNombre());
		}
		else{
			pist.setPista("Encontraste al ladron: " + ladron.getNombre() + " pero la orden de arresto no es correcta");
		}
			
		return pist;
	}
	
	public boolean ladronCapturado(){
		return capturado != null;
	}

	public void dormir() {
		Tiempo.getInstance().consumirTiempo(8);
	}

	public String crearOrdenDeArresto(String sexo, String hobby,
			String cabello, String senia, String vehiculo) {
		Tiempo.getInstance().consumirTiempo(3);
		ArrayList<Ladron> sospechosos = Ladrones.getInstance().getLadronesConCaracteristicas(sexo, hobby, cabello, senia, vehiculo);
		String sospe= "";
		if (sospechosos.size()> 1){
			sospe = "Sospechosos:";
			for (int i = 0; i<sospechosos.size(); i++){
				sospe = sospe + " " + sospechosos.get(i).getNombre() + "\n";
			}	
		}
		else if (sospechosos.size() == 1 ){
			sospe = "Se emitio una orden de arresto para: " + sospechosos.get(0).getNombre();
			this.orden = new OrdenDeArresto(sospechosos.get(0).getNombre());
		}
		else if (sospechosos.size() == 0){
			sospe = "No se encontraron sospechosos que respondan a esas carcteristicas";
			
		}
		return sospe; 
	}
	
	public Ladron getLadron(){
		return this.capturado;
	}
	
	public String obtenerRangoStr(){
		if (rango.esDetective()){
			return "Detective";
		}else if (rango.esInvestigador()){
			return "Investigador";
		}else if (rango.esSargento()){
			return "Sargento";
		}else{
			return "Novato";
		}
	}
	
	public boolean ladronCapturadoConOrden(){
		if (capturado == null) return false;
		if (capturado.getNombre() == orden.getNombre())
			return true;
		return false;
	}
}
