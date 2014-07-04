package modeloUnitTests;

import static org.junit.Assert.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;

import modelo.*;


public class juegoTest {

	@Test
	public void crearJuegoTest() throws MapaSeQuedoSinCiudades, ArchivoFaltante {
		Juego juego= new Juego();
		assertTrue(juego.cantidadPolicias() == 0);
	}
	
	@Test
	public void agregarPoliciaTest() throws MapaSeQuedoSinCiudades, ArchivoFaltante{
		Policia poli = new Policia("Pepe");
		Juego juego = new Juego();
		juego.agregarPolicia(poli);
		assertEquals(poli , juego.obtenerPolicia("Pepe"));
	}
	
	@Test
	public void guardar() throws ParserConfigurationException, MapaSeQuedoSinCiudades, ArchivoFaltante{
		Policia poli = new Policia("pepe");
		Juego jue = Juego.cargarJuego();
		jue.agregarPolicia(poli);
		try {
			jue.guardarJuego();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
