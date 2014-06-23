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
		Ciudad destino = new Ciudad("Chascomus",0,0);
		Ciudad origen = new Ciudad("Buenos Aires", 1, 0);
		poli.asignarCiudad(origen);
		poli.viajarACiudad(destino);
		Ciudad ciudadActual = poli.obtenerCiudadActual();
		assertEquals(destino, ciudadActual);
		assertEquals(ciudadActual.getNombre(), "Chascomus");
	}
	
	@Test
	public void testPoliciaIgualAOtro(){
		Policia poli1 = new Policia("Pedro");
		Policia poli2 = new Policia("Pedro");
		assertEquals(poli1, poli2);
	}
}
