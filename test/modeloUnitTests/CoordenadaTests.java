package modeloUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.*;

public class CoordenadaTests {
	@Test
	public void distanciaCoordenadasTest(){
		Coordenada p1 = new Coordenada(0,1);
		Coordenada p2 = new Coordenada(0,2);
		assertEquals(new Double(p1.distancia(p2)), new Double(1));
	}
	
	@Test
	public void distanciaCoordenadasNegativasTest(){
		Coordenada p1 = new Coordenada(2,1);
		Coordenada p2 = new Coordenada(-1,-2);
		assertEquals(new Double(p1.distancia(p2)), new Double(Math.sqrt(18)));
	}
}
