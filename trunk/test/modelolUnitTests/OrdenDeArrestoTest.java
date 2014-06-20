package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import control.OrdenDeArresto;

public class OrdenDeArrestoTest {

	@Test
	public void constructorTest() {
		OrdenDeArresto orden = new OrdenDeArresto("Pablo");
		assertEquals("Pablo", orden.getNombre());
		
	}

}
