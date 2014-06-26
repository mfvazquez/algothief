package modeloUnitTests;

import java.util.ArrayList;

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
	
	@Test
	public void dormirTest(){
		Policia poli = new Policia("Carlos");
		Tiempo.getInstance().reiniciar();
		assertEquals("Lunes 7hs", Tiempo.getInstance().fecha());
		poli.dormir();
		assertEquals("Lunes 15hs", Tiempo.getInstance().fecha());
	}
	
	@Test
	public void crearOdenDeArrestoTest(){
		Policia poli = new Policia("Carlos");
		String sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "", "", "");
		assertEquals("Sospechosos: Nick Brunch Len Bulk", sospechoso);
		sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "Rubio", "", "");
		assertEquals("No se encontraron sospechosos que respondan a esas carcteristicas", sospechoso);
		sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "Negro", "", "");
		assertEquals("Se emitio una orden de arresto para: Nick Brunch", sospechoso);
	
		
	}
	
}
