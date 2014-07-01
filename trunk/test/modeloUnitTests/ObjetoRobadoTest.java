package modeloUnitTests;

import static org.junit.Assert.*;
import modelo.*;

import org.junit.Test;

public class ObjetoRobadoTest {

	@Test
	public void leerObjetos(){
		ObjetoComun objcom = new ObjetoComun("Roma");
		assertEquals(objcom.getObjeto(), "el techo de la capilla sixtina");
		ObjetoValioso objval = new ObjetoValioso("Roma");
		assertEquals(objval.getObjeto(), "la corona del Cesar");
		ObjetoMuyValioso objmval = new ObjetoMuyValioso("Roma");
		assertEquals(objmval.getObjeto(), "la sortija del Papa");
		objmval = new ObjetoMuyValioso("El Cairo");
		assertEquals(objmval.getObjeto(), "la serpiente de Cleopatra");
	}
}
