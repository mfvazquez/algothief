package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

import java.util.List;


public class MapaTests {
	
	@Test
	public void crearMapa() throws ArchivoFaltante {
		Mapa mapa = Mapa.getInstance();
		assertFalse(mapa == null);
	}
	
	@Test
	public void singletoneTest() throws ArchivoFaltante{
		Mapa mapa = Mapa.getInstance();
		Mapa mapa2= Mapa.getInstance();
		assertTrue(mapa == mapa2);
		
	}
	
	@Test
	public void ciudadesDetinoTest() throws MapaSeQuedoSinCiudades, ArchivoFaltante{
		List<Ciudad> destinos = Mapa.getInstance().ciudadesDestino(Mapa.getInstance().verCiudadInicial());
		for (int i = 0; i< destinos.size(); i++){
			assertTrue(destinos.get(i).getNombre() instanceof String);
		}
	}
}
