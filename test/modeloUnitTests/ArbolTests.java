package modeloUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.*;
import java.util.ArrayList;

public class ArbolTests {

	@Test
	public void crearArbolyVerRaiz() {
		Arbol<Integer> arbol = new Arbol<Integer>(1);
		assertEquals(arbol.verRaiz(), new Integer(1));
	}
	
	@Test
	public void agregarHijoAPadreInexistenteFalla() {
		Arbol<String> arbol = new Arbol<String>("1");
		assertFalse(arbol.agregarHijo("2", "3"));
	}
	
	@Test
	public void agregarHijoAPadreNoFalla() {
		Arbol<String> arbol = new Arbol<String>("1");
		assertTrue(arbol.agregarHijo("1", "2"));
	}
	
	@Test
	public void devolverPadre() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "2");
		assertEquals(arbol.verPadre("2"), "1");
	}
	
	@Test
	public void devolverPadreConVariosNodos() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		arbol.agregarHijo("1", "12");
		arbol.agregarHijo("11", "111");
		arbol.agregarHijo("11", "112");
		arbol.agregarHijo("12", "121");
		arbol.agregarHijo("12", "122");
		arbol.agregarHijo("12", "123");
		assertEquals(arbol.verPadre("123"), "12");
	}
	
	@Test
	public void devolverPadreEsNullSiElElementoNofueGuardado() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "2");
		assertEquals(arbol.verPadre("5"), null);
	}
	
	@Test
	public void verHijosDevuelvelosHijos() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		arbol.agregarHijo("1", "12");
		ArrayList<String> hijos = new ArrayList<String>();
		hijos.add("11");
		hijos.add("12");
		assertEquals(arbol.verHijos("1"), hijos);
	}
	
	@Test
	public void verHijosDevuelveNullSiPadreNoExiste() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		arbol.agregarHijo("1", "12");
		assertEquals(arbol.verHijos("2"), null);
	}
	
	@Test
	public void verHijosDeVariosNodos() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		arbol.agregarHijo("1", "12");
		arbol.agregarHijo("11", "111");
		arbol.agregarHijo("11", "112");
		arbol.agregarHijo("12", "121");
		arbol.agregarHijo("12", "122");
		arbol.agregarHijo("12", "123");
		ArrayList<String> hijos = new ArrayList<String>();
		hijos.add("121");
		hijos.add("122");
		hijos.add("123");
		assertEquals(arbol.verHijos("12"), hijos);
	}
	
	@Test
	public void verPadreDeRaiz() {
		Arbol<String> arbol = new Arbol<String>("1");
		assertEquals(arbol.verPadre("1"), null);
	}
	
	@Test
	public void verSiExisteElementoAgregado() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		assertTrue(arbol.existe("11"));
		assertTrue(arbol.existe("1"));
	}
	
	@Test
	public void verSiNoExisteElementoNoAgregado() {
		Arbol<String> arbol = new Arbol<String>("1");
		arbol.agregarHijo("1", "11");
		assertFalse(arbol.existe("2"));
		assertFalse(arbol.existe("22"));
	}
}
