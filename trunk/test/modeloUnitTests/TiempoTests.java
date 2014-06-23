package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Tiempo;


public class TiempoTests {

	@Test
	public void testTiempo() {
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertEquals(tiempo.getDia(), "Lunes");
		assertEquals(tiempo.getHora(), 07);
	}		
	
	@Test
	public void testAumentarHora(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
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
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertEquals(tiempo.getDia(), "Lunes");
		tiempo.consumirTiempo(24);
		assertEquals(tiempo.getDia(), "Martes");
		tiempo.consumirTiempo(30);
		assertEquals(tiempo.getDia(), "Miercoles");
	}
	
	@Test
	public void testAgregarMuchasHoras(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		tiempo.consumirTiempo(72);
		assertEquals(tiempo.getDia(), "Jueves");
		tiempo.consumirTiempo(72);
		assertEquals(tiempo.getDia(), "Domingo");
		tiempo.consumirTiempo(45);
		assertTrue(tiempo.terminoTiempo());
	}
	
	@Test
	public void testFecha(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertTrue("Lunes 7hs".equals(tiempo.fecha()));
	}
	
	
}