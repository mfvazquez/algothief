
import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import control.Policia;

@SuppressWarnings("deprecation")
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
		Assert.assertTrue(policia.cantidadMisionesResueltas() == 0);
		
		Mision mision = policia.nuevaMision();
		Ciudad ciudadActual = mision.obtenerCiudadActual();
		Puerto puerto = ciudadActual.visitarPuerto(policia);
		Pista pista = puerto.obtenerPista(policia);
		Assert.assertTrue(pista.comoString = "Se fue en un auto con bandera azul, blanca y roja");
		Biblioteca biblioteca = ciudadActual.visitarBiblioteca(policia);
		pista = biblioteca.obtenerPista(policia);
		Assert.assertTrue(pista.comoString() == "Leyó sobre el imperio de Napoleón Bonaparte");
		
		Ciudad[] ciudadesDestino = new Ciudad[5];
		ciudadActual.obtenerDestinos(ciudadesDestino);
		Ciudad ciudadDestino = ciudadesDestino[1];
		policia.viajarACiudad(ciudadActual,ciudadDestino);
		Assert.assertTrue(ciudadActual == ciudadDestino);
	}

}