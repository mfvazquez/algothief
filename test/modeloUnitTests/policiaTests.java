package modeloUnitTests;

import org.junit.Test;
import static org.junit.Assert.*;
import modelo.*;

public class policiaTests {
	
	@Test
	public void testPolicia() {
		Policia poli = new Policia("Harle");
		assertEquals(0, poli.cantidadMisionesResueltas());
	}
	
	@Test
	public void testViajarACiudad() {
		Policia poli = new Policia("Harle");
		Ciudad ciudad = new Ciudad("Chascomus",0,0);
		poli.viajarACiudad(ciudad);
		Ciudad ciudadActual = poli.obtenerCiudadActual();
		assertEquals(ciudad, ciudadActual);
		assertEquals(ciudadActual.getNombre(), "Chascomus");
	}
	
	@Test
	public void testPoliciaIgualAOtro(){
		Policia poli1 = new Policia("Pedro");
		Policia poli2 = new Policia("Pedro");
		assertEquals(poli1, poli2);
	}
}
