package modeloUnitTests;

import static org.junit.Assert.*;
import modelo.*;

import org.junit.Test;

public class RangoStrategyTest {

	@Test
	public void crearObjetosRobados() {
		RangoStrategy rango = new RangoNovatoStrategy();
		ObjetoRobado objeto = rango.elegirObjetoRobado("Roma");
		assertTrue(objeto.esObjetoComun());
		rango = new RangoDetectiveStrategy();
		objeto = rango.elegirObjetoRobado("Roma");
		assertTrue(objeto.esObjetoValioso());
		rango = new RangoInvestigadorStrategy();
		objeto = rango.elegirObjetoRobado("Roma");
		assertTrue(objeto.esObjetoValioso());
		rango = new RangoSargentoStrategy();
		objeto = rango.elegirObjetoRobado("Roma");
		assertTrue(objeto.esObjetoMuyValioso());
	}
	
	@Test
	public void pistasCorrectas() {
		RangoStrategy rango = new RangoNovatoStrategy();
		Pista pista = new PistaFacil();
		assertTrue(rango.nivelDePistaCorrecto(pista));
		rango = new RangoDetectiveStrategy();
		assertFalse(rango.nivelDePistaCorrecto(pista));
		pista = new PistaMedia();
		assertTrue(rango.nivelDePistaCorrecto(pista));
		rango = new RangoInvestigadorStrategy();
		assertTrue(rango.nivelDePistaCorrecto(pista));
		rango = new RangoSargentoStrategy();
		pista = new PistaDificil();
		assertTrue(rango.nivelDePistaCorrecto(pista));
	}
}
