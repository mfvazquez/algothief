package modeloUnitTests;

import static org.junit.Assert.*;
import modelo.ObjetosRobados;

import org.junit.Test;

public class ObjetosRobadosTest {

	@Test
	public void mostrarObjetosTest() {
		ObjetosRobados.getInstance().mostrarObjetos();
	}

}
