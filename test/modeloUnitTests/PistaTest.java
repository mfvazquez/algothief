package modeloUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

public class PistaTest {

	@Test
	public void pistaPorDefectotest() {
		Pista pist = new PistaFacil();
		assertEquals("No se vio a esa persona por aca", pist.getPista());
	}
	
	@Test
	public void constructorConPista(){
		Pista pist = new PistaFacil();
		pist.setPista("Tenia el pelo rubio");
		assertEquals("Tenia el pelo rubio", pist.getPista());
	}

}
