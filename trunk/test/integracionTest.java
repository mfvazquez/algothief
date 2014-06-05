package tpfinalalgo3;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class integracionTest {

	@Test
	public void testAgregarUnPolicia() {
		Policia policia = new Novato('Gabi');
		Juego juego = new Juego();
		juego.agregarPolicia(policia);
		Policia policia2 = juego.getPolicia('Gabi');
		
		Assert.assertTrue(policia = policia2);
	}

	@Test
	public void testConsumirTiempo(){
		Policia policia = new Novato('Gabi');
		
		Assert.assertTrue(policia.misonesCompletadas() = 0);
		Mision mision = policia.crearNuevaMision();
		Assert.assertTrue(mision.fecha() = 0107 );
		Ciudad ciudad = mision.ciudadActual();
		ciudad.aeropuerto().pedirPista();
		Assert.assertTrue(mision.fecha() = 0108 );
		
		ciudad.biblioteca().pedirPista();
		Asser.assertTrue(mision.Fecha() = 0110);
	
		ciudad.banco().pedirPista();
		Asser.assertTrue(mision.Fecha() = 0113);
		
		mision.crearOrdenDeArresto();
		Assert.assertTrue(mision.Fecha() = 0116);
		
	}

	@Test
	public void testPedirPista() {
		aeropuerto = new Aeropuerto();
		Pista pista = new PistaFacil; 
		aeropuerto setPista(pista);
		
		Assert.assertTrue(aeropuerto.pedirPista() = pista);
	}
	
	

}