package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

import java.util.List;


public class RutaDeEscapeTests {
	@Test
	public void crearRuta() {
		Mapa mapa = new Mapa("archivo inexistente");
		RutaDeEscape ruta = new RutaDeEscape(mapa, 3);
		assertEquals(ruta.size(),3);
	}
}
