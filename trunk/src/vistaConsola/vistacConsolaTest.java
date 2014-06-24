package vistaConsola;

import static org.junit.Assert.*;
import modelo.Ciudad;
import modelo.Juego;
import modelo.Mapa;
import modelo.Policia;
import modelo.Tiempo;

import org.junit.Test;

import java.util.*;

public class vistacConsolaTest {

	@Test
	public void test() {
		
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String entradaTeclado = entradaScanner.nextLine();
		System.out.println("Ingreso el nombre: " + entradaTeclado);
		Juego juego = new Juego();
		Policia poli = new Policia(entradaTeclado);
		juego.agregarPolicia(poli);
		juego.nuevaMision(poli);
		Boolean salir = false;
		
		while (!salir & !poli.ladronCapturado()){
			System.out.println("Se encuentra en la ciudad de: " + poli.obtenerCiudadActual().getNombre());
			System.out.println("Que desa hacer?");
			System.out.println("1. entrar a un edificio");
			System.out.println("2. viajar");
			System.out.println("3. Salir");
			entradaTeclado = entradaScanner.nextLine();
			if (entradaTeclado.equals("1"))
				this.visitarEdificio(poli);
			else if (entradaTeclado.equals("2")) 
				this.viajar(poli);
			else if (entradaTeclado.equals("3"))
				salir = true;
		}
	}
	
	public void visitarEdificio(Policia poli){
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Que edificio desea visitar?");
		System.out.println("1. Banco");
		System.out.println("2. Aeropuerto");
		System.out.println("3. Biblioteca");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			System.out.println(poli.visitarEdificio(poli.obtenerCiudadActual().getBanco()).getPista());
		else if (entradaTeclado.equals("2"))
			System.out.println(poli.visitarEdificio(poli.obtenerCiudadActual().getAeropuerto()).getPista());
		else if (entradaTeclado.equals("3"))
			System.out.println(poli.visitarEdificio(poli.obtenerCiudadActual().getBiblioteca()).getPista());
		System.out.println(Tiempo.getInstance().fecha());
	}
	
	public void viajar(Policia poli){
		Scanner entradaScanner = new Scanner(System.in);
		List<Ciudad> destinos = Mapa.getInstance().ciudadesAdyacentes(poli.obtenerCiudadActual());
		System.out.println("A donde desea viajar");
		for (int i = 0; i< destinos.size(); i++){
		System.out.println(destinos.get(i).getNombre());
		}
		String entrada = entradaScanner.nextLine();
		int dest = Integer.parseInt(entrada) -1;
		poli.viajarACiudad(destinos.get(dest));
		System.out.println(Tiempo.getInstance().fecha());
	}
}
