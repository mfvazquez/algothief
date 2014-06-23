package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

import java.util.List;


public class RutaDeEscapeTests {
	@Test
	public void crearRuta() {
		Mapa mapa = Mapa.getInstance();
		RangoNovatoStrategy rango = new RangoNovatoStrategy();
		RutaDeEscape ruta = new RutaDeEscape(rango);
		assertEquals(ruta.size(),4);
	}
}
