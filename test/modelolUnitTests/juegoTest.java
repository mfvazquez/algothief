package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Juego;
import control.Mapa;
import control.Policia;

public class juegoTest {

	@Test
	public void crearJuegoTest() {
		Juego juego= new Juego();
		assertTrue(juego.getLadrones().size() == 3);
		assertTrue(juego.getMapa() instanceof Mapa);
		assertTrue(juego.getPolicias().size() == 0);
	}
	
	@Test
	public void agregarPoliciaTest(){
		Policia poli = new Policia("Pepe");
		Juego juego = new Juego();
		juego.agregarPolicia(poli);
		assertEquals("Pepe" , juego.getPolicias().get(0).getNombre() );
	}
	
	@Test
	public void alAgregarPoliciaLePasaUnaReferenciaAlJuegoTest(){
		Policia poli = new Policia("Pepe");
		Juego juego = new Juego();
		juego.agregarPolicia(poli);
		assertEquals(juego , juego.getPolicias().get(0).getJuego() );
	}
}
