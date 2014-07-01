package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class AlgothiefModelo {

	private Juego juego;
	private Policia policia;
	
	public AlgothiefModelo(){
		juego = new Juego();
	}
	
	public void iniciarMision(String nombrePolicia){
		policia = new Policia("Pedro");
		juego.agregarPolicia(policia);
		juego.nuevaMision(policia);
	}
	
	public String getCiudadActual(){
		Ciudad actual = policia.obtenerCiudadActual();
		return actual.getNombre();
	}
	
	public List<Ciudad> getCiudadesDestino(){
		Ciudad actual = policia.obtenerCiudadActual();
		return  Mapa.getInstance().ciudadesAdyacentes(actual);
		
		/*
		
		List<Ciudad> destinos;
		Ciudad actual = policia.obtenerCiudadActual();
		destinos = Mapa.getInstance().ciudadesAdyacentes(actual);
		
		ArrayList<String> destinosStr = new ArrayList<String>();
		for (int i = 0; i < destinos.size(); i++){
			destinosStr.add(destinos.get(i).getNombre());
		}
		return destinosStr;*/
	}
	
	public List<Edificio> getEdificios(){
		ArrayList<Edificio> lista = new ArrayList<Edificio>();
		Ciudad ciudad = policia.obtenerCiudadActual();
		lista.add(ciudad.getAeropuerto());
		lista.add(ciudad.getBanco());
		lista.add(ciudad.getBiblioteca());
		return lista;
		/*
		ArrayList<String> edificios = new ArrayList<String>();
		edificios.add("Aeropuerto");
		edificios.add("Banco");
		edificios.add("Biblioteca");
		return edificios;*/
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
		return pista.getPista();
	}
}
