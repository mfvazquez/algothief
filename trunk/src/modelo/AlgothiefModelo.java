package modelo;

import java.util.ArrayList;
import java.util.List;

public class AlgothiefModelo {

	private Juego juego;
	private Policia policia;
	
	public AlgothiefModelo(){
		juego = new Juego();
		policia = null;
	}
	
	public void iniciarMision(String nombrePolicia){
		policia = new Policia(nombrePolicia);
		if (juego.policiaExistente(policia)){
			policia = juego.obtenerPolicia(nombrePolicia);
		}else{
			juego.agregarPolicia(policia);
		}
		juego.nuevaMision(policia);
	}
	
	public String getCiudadActual(){
		Ciudad actual = policia.obtenerCiudadActual();
		return actual.getNombre();
	}
	
	public List<String> getCiudadesDestino(){
		Ciudad actual = policia.obtenerCiudadActual();
		List<Ciudad> destinos = Mapa.getInstance().ciudadesAdyacentes(actual);
		ArrayList<String> destinosStr = new ArrayList<String>();
		for (int i = 0; i < destinos.size(); i++){
			destinosStr.add(destinos.get(i).getNombre());
		}
		return destinosStr;
	}
	
	public List<String> getEdificios(){
		ArrayList<String> lista = new ArrayList<String>();
		Ciudad ciudad = policia.obtenerCiudadActual();
		lista.add(ciudad.getAeropuerto().getTipo());
		lista.add(ciudad.getBanco().getTipo());
		lista.add(ciudad.getBiblioteca().getTipo());
		return lista;
	}
	
	public String getTiempoStr(){
		return Tiempo.getInstance().fecha();
	}
	
	private Ciudad getCiudad(String nombre){
		return Mapa.getInstance().buscarCiudad(nombre);
	}
	
	private Edificio getEdificio(String nombre){
		Ciudad actual = policia.obtenerCiudadActual();
		if (nombre == actual.getAeropuerto().getTipo()){
			return actual.getAeropuerto();
		}
		if (nombre == actual.getBiblioteca().getTipo()){
			return actual.getBiblioteca();
		}
		if (nombre == actual.getBanco().getTipo()){
			return actual.getBanco();
		}
		return null;
	}
	
	public void viajar(String ciudadStr){
		Ciudad ciudad = getCiudad(ciudadStr);
		policia.viajarACiudad(ciudad);
	}
	
	public boolean tiempoTerminado(){
		return Tiempo.getInstance().terminoTiempo();
	}
	
	public String visitarEdificio(String edificioStr){
		Edificio edificio = getEdificio(edificioStr);
		Pista pista = policia.visitarEdificio(edificio);
		if (pista == null) return null;
		return pista.getPista();
	}
	
	public String getRango(){
		return policia.obtenerRangoStr();
	}
	
	public String crearOrdenDeArresto(String[] array){
		return policia.crearOrdenDeArresto(array[0], array[1], array[2], array[3], array[4]);
	}
	
	public boolean ladronCapturadoConOrden(){
		return policia.ladronCapturadoConOrden();
	}
	
	public void reiniciar(){
		Tiempo.getInstance().reiniciar();
		Mapa.getInstance().reiniciar();
		policia.entregarLadron();
	}
	
	public String objetoRobado(){
		return policia.getMision().objetoRobadoStr();
	}
	
	public String ciudadInicio(){
		return juego.ciudadInicioStr();
	}
	
	public String sexoLadron(){
		return policia.sexoLadron();
	}
	
	public boolean enEspera(){
		return Tiempo.getInstance().enEspera();
	}
	
	public void esperarUnaHora(){
		Tiempo.getInstance().esperarUnaHora();
	}
	
	public boolean ladronCapturado(){
		return policia.ladronCapturado();
	}
	
	public String nombreLadronCapturado(){
		return policia.nombreLadron();
	}
	
	public void aumentarCasosResueltos(){
		policia.misionResuelta(true);
	}
	
	public String armaLadron(){
		return policia.armaDelLadron();
	}
	
}
