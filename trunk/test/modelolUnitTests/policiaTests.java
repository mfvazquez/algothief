package controlUnitTests;

import org.junit.Test;
import static org.junit.Assert.*;
import control.*;

public class policiaTests {
	
	@Test
	public void testPolicia() {
		Policia poli = new Policia("Harle");
		assertEquals(0, poli.cantidadMisionesResueltas());
	}
	
	@Test
	public void testNuevaMision() {
		Policia poli = new Policia("Harle");
		poli.nuevaMision();
		assertEquals("Buenos Aires", (poli.obtenerCiudadActual()).getNombre());
		/*Tiempo tiempo;
		assertEquals(tiempo.getHora(), 0700);
		assertEquals(tiempo.getDia(), "lunes");*/
	}
	
	@Test
	public void testViajarACiudad() {
		Policia poli = new Policia("Harle");
		Ciudad ciudad = new Ciudad("Chascomus",0,0);
		poli.viajarACiudad(ciudad);
		Ciudad ciudadActual = poli.obtenerCiudadActual();
		assertEquals(ciudad, ciudadActual);
		assertEquals(ciudadActual.getNombre(), "Chascomus");
	}
}
