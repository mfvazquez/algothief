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
	
	public Ciudad getCiudad(String nombre){
		return Mapa.getInstance().buscarCiudad(nombre);
	}
	
	public void viajar(Ciudad ciudad){
		policia.viajarACiudad(ciudad);
	}
}
