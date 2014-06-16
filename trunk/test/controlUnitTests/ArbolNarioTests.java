package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.*;

public class ArbolNarioTests {

	@Test
	public void crearArbolVacio() {
		ArbolNario<Integer> arbol = new ArbolNario<Integer>(2);
		try{
		arbol.agregar(2, 1);
			assertTrue(false);
		}catch(ErrorNodoNoEncontrado e){
			assertTrue(true);
		}
	}
	
	@Test
	public void agregarHijoNoTiraError() {
		ArbolNario<Integer> arbol = new ArbolNario<Integer>(3);
		try{
			arbol.agregar(1);
			assertTrue(arbol.agregar(1, 2));
		}catch(ErrorNodoNoEncontrado e){
			assertTrue(false);
		}
	}

}
