package modeloIntegracionTests;

import modelo.*;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class juegoTests {

	@Test
	public void crearPoliciaYaCreadoTest(){
		Juego juego = new Juego();
		juego.agregarPolicia(new Policia("Pedro"));
		juego.agregarPolicia(new Policia("Juan"));
		juego.agregarPolicia(new Policia("Pedro"));
		assertTrue(juego.policiaExistente(new Policia("Pedro")));
		assertTrue(juego.policiaExistente(new Policia("Juan")));
		assertEquals(juego.cantidadPolicias(), 2);
	}
	
	
	// Prueba temporal, cuando esten fijadas las estadisticas del policia se podran agregar los assert
	@Test
	public void policiaVisitaEdificios(){
		Juego juego = new Juego();
		Policia policia = new Policia("Pedro");
		juego.agregarPolicia(policia);
		juego.nuevaMision(policia);
		
		Ciudad actual = policia.obtenerCiudadActual();
		Edificio edificio;
		Pista pista;
		List<Ciudad> destinos;
		
		while(true){
			edificio = actual.getBanco();
			pista = policia.visitarEdificio(edificio);
			if (Tiempo.getInstance().terminoTiempo()){
				System.out.format("SE ACABO EL TIEMPO\n");
				return;
			}
			System.out.format(Tiempo.getInstance().toString()+ '\n');
			System.out.format(pista.getPista() + '\n');
			
			edificio = actual.getAeropuerto();
			pista = policia.visitarEdificio(edificio);
			if (Tiempo.getInstance().terminoTiempo()){
				System.out.format("SE ACABO EL TIEMPO\n");
				return;
			}
			if (policia.ladronCapturado()){
				System.out.format("SE CAPTURO AL LADRON\n");
				return;
			}
			System.out.format(Tiempo.getInstance().toString()+ '\n');
			System.out.format(pista.getPista() + '\n');
			
			edificio = actual.getBiblioteca();
			pista = policia.visitarEdificio(edificio);
			if (Tiempo.getInstance().terminoTiempo()){
				System.out.format("SE ACABO EL TIEMPO\n");
				return;
			}
			System.out.format(Tiempo.getInstance().toString() + '\n');
			System.out.format(pista.getPista() + '\n');
			
			destinos = Mapa.getInstance().ciudadesAdyacentes(actual);
			for (int i = 0; i < destinos.size(); i++){
				System.out.format(destinos.get(i).getNombre() + '\n');
			}
			
			Double subindice = Math.floor(Math.random()*destinos.size());
			actual = destinos.get(subindice.intValue());
			
			policia.viajarACiudad(actual);
			if (Tiempo.getInstance().terminoTiempo()){
				System.out.format("SE ACABO EL TIEMPO\n");
				return;
			}
			System.out.format("Viajando a " + destinos.get(0).getNombre() + " Tiempo = " + Tiempo.getInstance().toString() + "\n\n");
		}
	}
}
