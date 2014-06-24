package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;


public class juegoTest {

	@Test
	public void crearJuegoTest() {
		Juego juego= new Juego();
		assertTrue(juego.cantidadPolicias() == 0);
	}
	
	@Test
	public void agregarPoliciaTest(){
		Policia poli = new Policia("Pepe");
		Juego juego = new Juego();
		juego.agregarPolicia(poli);
		assertEquals(poli , juego.obtenerPolicia("Pepe"));
	}
}
