package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

import java.util.List;


public class RutaDeEscapeTests {
	@Test
	public void crearRuta() {
		Mapa mapa = Mapa.getInstance();
		RutaDeEscape ruta = new RutaDeEscape(3);
		assertEquals(ruta.size(),3);
	}
}
