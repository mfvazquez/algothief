package controlUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import control.*;

public class CiudadTests {
	@Test
	public void distanciaCoordenadasTest(){
		Ciudad ciudad1 = new Ciudad("Pekin", 0, 1);
		Ciudad ciudad2 = new Ciudad("Los Angeles", 0, 2);
		assertEquals(new Double(ciudad1.distancia(ciudad2)), new Double(1));
	}
	
	@Test
	public void distanciaCoordenadasNegativasTest(){
		Ciudad ciudad1 = new Ciudad("Pekin", 2, 1);
		Ciudad ciudad2 = new Ciudad("Los Angeles", -1, -2);
		assertEquals(new Double(ciudad1.distancia(ciudad2)), new Double(Math.sqrt(18)));
	}
	
	@Test
	public void generadorDePistasTest(){
		Policia poli = new Policia("Pepe");
		Ciudad ciudad = new Ciudad("Pekin", 0,1);
		ciudad.generarPistas();
		Edificio banco = ciudad.visitarEdificio(poli,0);
		Edificio aeropuerto = ciudad.visitarEdificio(poli,1);
		Edificio biblio = ciudad.visitarEdificio(poli,2);
		assertEquals("Tenia pelo rubio", banco.pedirPista().getPista());
		assertEquals("Se fue en un avion con bandera azul y blanca", aeropuerto.pedirPista().getPista());
		assertEquals("Estuvo leyendo sobre la revolucion de mayo", biblio.pedirPista().getPista());
		
	}
}
