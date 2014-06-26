package modeloUnitTests;

import static org.junit.Assert.*;
import modelo.Pistas;

import org.junit.Test;

public class PistasTest {

	@Test
	public void verPistasTest() {
		Pistas.getInstance().mostrarPistas();
	}

}
