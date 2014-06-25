package modeloUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modelo.Ladron;
import modelo.Ladrones;

import org.junit.Test;

public class LadronesTest {

	@Test
	public void creacionTest() {
		Ladron ladri = Ladrones.getInstance().getLadrones().get(5);
		
		System.out.println(ladri.getNombre());
		System.out.println(ladri.getCabello());
		System.out.println(ladri.gethobby());
		System.out.println(ladri.getSenia());
		System.out.println(ladri.getSexo());
		System.out.println(ladri.getVehiculo());
	}

	@Test
	public void sospechososTest(){
		ArrayList<Ladron> sospechosos = Ladrones.getInstance().getLadronesConCaracteristicas("Masculino", "Alpinismo","" , "", "");
		assertEquals(2, sospechosos.size());
	}
}
