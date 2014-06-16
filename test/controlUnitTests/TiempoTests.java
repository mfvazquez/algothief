package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Tiempo;


public class TiempoTests {

	@Test
	public void testTiempo() {
		Tiempo tiempo = new Tiempo();
		assertEquals(tiempo.getDia(), "Lunes");
		assertEquals(tiempo.getHora(), 07);
	}		
	
	@Test
	public void testAumentarHora(){
		Tiempo tiempo = new Tiempo();
		assertEquals(tiempo.getHora(), 07);
		tiempo.consumirTiempo(10);
		assertEquals(tiempo.getHora(), 17);
		tiempo.consumirTiempo(12);
		assertEquals(tiempo.getHora(), 05);
		tiempo.consumirTiempo(24);
		assertEquals(tiempo.getHora(), 05);
		assertEquals(tiempo.getDia(), "Miercoles");
	}
	
	@Test
	public void testCambiaDia(){
		Tiempo tiempo = new Tiempo();
		assertEquals(tiempo.getDia(), "Lunes");
		tiempo.consumirTiempo(24);
		assertEquals(tiempo.getDia(), "Martes");
		tiempo.aumentoDia();
		assertEquals(tiempo.getDia(), "Miercoles");
	}
	
	@Test
	public void testFecha(){
		Tiempo tiempo = new Tiempo();
		assertTrue("Lunes 7hs".equals(tiempo.fecha()));
	}
	
	
}