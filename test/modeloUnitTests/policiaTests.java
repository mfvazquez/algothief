package modeloUnitTests;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

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
	public void crearOdenDeArrestoTest(){
		Policia poli = new Policia("Carlos");
		String sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "", "", "");
		assertEquals("Sospechosos: Nick Brunch Len Bulk", sospechoso);
		sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "Rubio", "", "");
		assertEquals("No se encontraron sospechosos que respondan a esas carcteristicas", sospechoso);
		sospechoso = poli.crearOrdenDeArresto("Masculino", "Alpinismo", "Negro", "", "");
		assertEquals("Se emitio una orden de arresto para: Nick Brunch", sospechoso);
	
	}
	
	/*@Test
	public void guardarTest(){
		Policia poli = new Policia("pepe");
		
		try {
			poli.guardarPolicia();
		} catch (DOMException | IOException | ParserConfigurationException
				| TransformerException e) {
					e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}*/
	
}
