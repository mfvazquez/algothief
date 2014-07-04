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
		for(int i = 7; tiempo.enEspera(); i++){
			assertEquals(tiempo.getHora(), i);
			tiempo.esperarUnaHora();
		}
	}
	
	@Test
	public void testCambiaDia(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertEquals(tiempo.getDia(), "Lunes");
		tiempo.consumirTiempo(24);
		int i = tiempo.getHora();
		while (tiempo.enEspera()){
			assertEquals(tiempo.getHora(), i);
			tiempo.esperarUnaHora();
			i++;
			if (i >= 24) i = 0;
		}
		assertEquals(tiempo.getDia(), "Martes");
		tiempo.consumirTiempo(30);
		i = tiempo.getHora();
		while (tiempo.enEspera()){
			assertEquals(tiempo.getHora(), i);
			tiempo.esperarUnaHora();
			i++;
			if (i >= 24) i = 0;
		}
		assertEquals(tiempo.getDia(), "Jueves");
	}
	
	
	
	@Test
	public void testFecha(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertTrue("Lunes 7 hs".equals(tiempo.fecha()));
	}
	
	@Test
	public void duermeDespuesDeLas11Test(){
		Tiempo tiempo = Tiempo.getInstance();
		tiempo.reiniciar();
		assertTrue("Lunes 7 hs".equals(tiempo.fecha()));
		tiempo.consumirTiempo(16);
		int i = tiempo.getHora();
		while (tiempo.enEspera()){
			assertEquals(tiempo.getHora(), i);
			tiempo.esperarUnaHora();
			i++;
			if (i >= 24) i = 0;
			if (i > 23 && i < 7){
				assertTrue(tiempo.durmiendo());
			}else{
				assertFalse(tiempo.durmiendo());
			}
		}
		assertEquals("Lunes 23 hs",tiempo.fecha());
	}
	
	
}