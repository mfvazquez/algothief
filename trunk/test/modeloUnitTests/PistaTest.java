package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Pista;

public class PistaTest {

	@Test
	public void pistaPorDefectotest() {
		Pista pist = new Pista();
		assertEquals("No se vio a esa persona por aca", pist.getPista());
	}
	
	@Test
	public void constructorConPista(){
		Pista pist = new Pista("Tenia el pelo rubio");
		assertEquals("Tenia el pelo rubio", pist.getPista());
	}

}
