
import static org.junit.Assert.*;

import java.util.ArrayList;

//import junit.framework.Assert;

import org.junit.Test;

import control.*;

//@SuppressWarnings("deprecation")
public class integracionTest {

	/*@Test
	public void testAgregarUnPolicia() {
		Policia policia = new Novato("Gabi");
		Juego juego = new Juego();
		juego.agregarPolicia(policia);
		Policia policia2 = juego.getPolicia("Gabi");
		
		Assert.assertTrue(policia == policia2);
	}

	@Test
	public void testConsumirTiempo(){
		Policia policia = new Novato("Gabi");
		
		Assert.assertTrue(policia.misonesCompletadas() == 0);
		Mision mision = policia.crearNuevaMision();
		Assert.assertTrue(mision.fecha() == 0107 );
		Ciudad ciudad = mision.ciudadActual();
		ciudad.aeropuerto().pedirPista();
		Assert.assertTrue(mision.fecha() == 0108 );
		
		ciudad.biblioteca().pedirPista();
		Assert.assertTrue(mision.Fecha() == 0110);
	
		ciudad.banco().pedirPista();
		Assert.assertTrue(mision.Fecha() == 0113);
		
		mision.crearOrdenDeArresto();
		Assert.assertTrue(mision.Fecha() == 0116);
		
	}

	@Test
	public void testPedirPista() {
		Aeropuerto aeropuerto = new Aeropuerto();
		Pista pista = new PistaFacil(); 
		aeropuerto.setPista(pista);
		
		Assert.assertTrue(aeropuerto.pedirPista() == pista);
	}*/
	
	@Test
	public void testIrACiudadYPedirPista() {
		Policia policia = new Policia("Lucas");
		assertEquals(policia.cantidadMisionesResueltas(), 0);
		
		Mision mision = policia.nuevaMision();
		Ciudad ciudadActual = policia.obtenerCiudadActual();
		
		Aeropuerto puerto = ciudadActual.visitarAeropuerto(policia);
		Pista pista = puerto.obtenerPista(mision);
		assertEquals(pista.getPista(), "Se fue en un auto con bandera azul, blanca y roja");
		Biblioteca biblioteca = ciudadActual.visitarBiblioteca(policia);
		pista = biblioteca.obtenerPista(policia);
		assertEquals(pista.getPista(), "Leyó sobre el imperio de Napoleón Bonaparte");
		
		ArrayList<Ciudad> ciudadesDestino = new ArrayList<Ciudad>();
		ciudadActual.obtenerDestinos(ciudadesDestino);
		Ciudad ciudadDestino = ciudadesDestino.get(0);
		assertEquals(ciudadDestino.getNombre(), "Chascomus");
		assertEquals(ciudadActual.getNombre(), "Buenos Aires");
		policia.viajarACiudad(ciudadDestino);
		ciudadActual = policia.obtenerCiudadActual();
		assertEquals(ciudadActual.getNombre(), "Chascomus");
		assertEquals(ciudadActual.getNombre(), ciudadDestino.getNombre());
	}
	
	@Test
	public void testViajarPorCiudades() {
		Policia yuta = new Policia("Pancho Villa");
		Mision robo = yuta.nuevaMision();
		Ciudad ciudadActual = yuta.obtenerCiudadActual();
		ArrayList<Ciudad> ciudadesDestino = new ArrayList<Ciudad>();
		ciudadActual.obtenerDestinos(ciudadesDestino);
		Ciudad ciudadDestino = ciudadesDestino.get(1);
		yuta.viajarACiudad(ciudadDestino);
		ciudadActual = yuta.obtenerCiudadActual();
		
		Aeropuerto puerto = ciudadActual.visitarAeropuerto(yuta);
		Pista pista = puerto.obtenerPista(robo);
		assertEquals(pista.getPista(), "Aca no es");
		assertEquals(ciudadActual.getNombre(), "Mar del Plata");
		
		ciudadActual.obtenerDestinos(ciudadesDestino);
		ciudadDestino = ciudadesDestino.get(2);
		yuta.viajarACiudad(ciudadDestino);
		ciudadActual = yuta.obtenerCiudadActual();
		assertEquals(ciudadActual.getNombre(), "Buenos Aires");
		ciudadActual.obtenerDestinos(ciudadesDestino);
		ciudadDestino = ciudadesDestino.get(0);
		yuta.viajarACiudad(ciudadDestino);
		ciudadActual = yuta.obtenerCiudadActual();
		assertEquals(ciudadActual.getNombre(), "Chascomus");
		assertTrue(robo.ladronEstaEnCiudad(ciudadActual));
		puerto = ciudadActual.visitarAeropuerto(yuta);
		pista = puerto.obtenerPista(robo);
		assertEquals(pista.getPista(), "Se fue en un auto con bandera azul, blanca y roja");
		}

}