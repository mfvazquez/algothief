package modeloIntegracionTests;

import modelo.*;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class juegoTests {

	@Test
	public void crearPoliciaYaCreadoTest(){
		Juego juego = new Juego();
		juego.agregarPolicia("Pedro");
		juego.agregarPolicia("Juan");
		juego.agregarPolicia("Pedro");
		assertTrue(juego.policiaExistente("Pedro"));
		assertTrue(juego.policiaExistente("Juan"));
		assertEquals(juego.cantidadPolicias(), 2);
	}
	
	
	// Prueba temporal, cuando esten fijadas las estadisticas del policia se podran agregar los assert
	@Test
	public void policiaVisitaEdificios(){
		Juego juego = new Juego();
		Policia policia = juego.agregarPolicia("Pedro");
		juego.nuevaMision(policia);
		
		Ciudad actual = policia.obtenerCiudadActual();
		Edificio edificio;
		Pista pista;
		List<Ciudad> destinos;
		
		for(int n = 0; n < 3; n++){
			edificio = actual.getBanco();
			pista = policia.visitarEdificio(edificio);
			System.out.format(Tiempo.getInstance().toString()+ '\n');
			System.out.format(pista.getPista() + '\n');
			
			edificio = actual.getAeropuerto();
			pista = policia.visitarEdificio(edificio);
			System.out.format(Tiempo.getInstance().toString()+ '\n');
			System.out.format(pista.getPista() + '\n');
			
			edificio = actual.getBiblioteca();
			pista = policia.visitarEdificio(edificio);
			System.out.format(Tiempo.getInstance().toString() + '\n');
			System.out.format(pista.getPista() + '\n');
			
			destinos = Mapa.getInstance().ciudadesAdyacentes(actual);
			for (int i = 0; i < destinos.size(); i++){
				System.out.format(destinos.get(i).getNombre() + '\n');
			}
			policia.viajarACiudad(destinos.get(0));
			actual = policia.obtenerCiudadActual();
			System.out.format("Viajando a " + destinos.get(0).getNombre() + " Tiempo = " + Tiempo.getInstance().toString() + "\n\n");
		}
	}
}