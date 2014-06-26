package modeloUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.Ladron;
import modelo.Ladrones;

import org.junit.Test;

public class LadronesTest {

	@Test
	public void creacionTest() {
		Ladrones.getInstance();
		for(Ladron l : Ladrones.getInstance().getLadrones()){
			System.out.println(l.getNombre());
		}
		
	}

	@Test
	public void sospechososTest(){
		ArrayList<Ladron> sospechosos = Ladrones.getInstance().getLadronesConCaracteristicas("Masculino", "Alpinismo","" , "", "");
		assertEquals(2, sospechosos.size());
	}
}
