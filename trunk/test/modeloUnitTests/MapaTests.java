package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

import java.util.List;


public class MapaTests {
	
	@Test
	public void crearMapa() {
		Mapa mapa = Mapa.getInstance();
		assertFalse(mapa == null);
	}
	
	@Test
	public void verCiudadInicial() {
		Mapa mapa = Mapa.getInstance();
		assertEquals(mapa.verCiudadInicial().getNombre(), "Buenos Aires");
	}
	
	@Test
	public void verAdyacentes() {
		Mapa mapa = Mapa.getInstance();
		List<Ciudad> adyacentes = mapa.ciudadesAdyacentes(mapa.verCiudadInicial());
		assertEquals(adyacentes.get(0).getNombre(), "Berlin");
		assertEquals(adyacentes.get(1).getNombre(), "Tokio");
		assertEquals(adyacentes.size(), 2);
	}
	
	@Test
	public void verAdyacentesMasProfundos() {
		Mapa mapa = Mapa.getInstance();
		List<Ciudad> adyacentes = mapa.ciudadesAdyacentes(mapa.verCiudadInicial());
		adyacentes = mapa.ciudadesAdyacentes(adyacentes.get(0));
		adyacentes = mapa.ciudadesAdyacentes(adyacentes.get(0));
		assertEquals(adyacentes.get(0).getNombre(), "Barcelona");
		assertEquals(adyacentes.get(1).getNombre(), "Washington");
		assertEquals(adyacentes.get(2).getNombre(), "Viena");
		assertEquals(adyacentes.get(3).getNombre(), "Berlin");
		assertEquals(adyacentes.size(), 4);
	}
	
	@Test
	public void singletoneTest(){
		Mapa mapa = Mapa.getInstance();
		Mapa mapa2= Mapa.getInstance();
		assertTrue(mapa == mapa2);
		
	}
	
}