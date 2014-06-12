package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Tiempo;

public class TiempoTests {

	@Test
	public void testTiempo() {
		Tiempo tiempo = new Tiempo();
		
		assertTrue(tiempo.getDia() == "Lunes");
		assertTrue(tiempo.getHora() == 07);
	}		
	
	@Test
	public void testAumentarHora(){
		Tiempo tiempo = new Tiempo();
		assertTrue(tiempo.getHora() == 07);
		tiempo.consumirTiempo(10);
		assertTrue(tiempo.getHora() == 17);
	
		tiempo.consumirTiempo(12);
		assertTrue(tiempo.getHora() == 05);
	}
	@Test
	public void testCambiaDia(){
		Tiempo tiempo = new Tiempo();
		assertTrue(tiempo.getDia() == "Lunes");
		tiempo.consumirTiempo(24);
		assertTrue(tiempo.getDia() == "Martes");
		tiempo.aumentoDia();
		assertTrue(tiempo.getDia() == "Miercoles");
	}
}
