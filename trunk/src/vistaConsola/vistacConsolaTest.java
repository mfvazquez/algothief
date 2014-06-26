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
			System.out.println("3. crear orden de arresto");
			System.out.println("4. Salir");
			entradaTeclado = entradaScanner.nextLine();
			if (entradaTeclado.equals("1"))
				this.visitarEdificio(poli);
			else if (entradaTeclado.equals("2")) 
				this.viajar(poli);
			else if (entradaTeclado.equals("3"))
				this.crearOrden(poli);
			else if (entradaTeclado.equals("4"))
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
	
	public void crearOrden(Policia poli){
		Scanner entradaScanner = new Scanner(System.in);
		String sexo="";
		String pelo="";
		String hobby="";
		String senia="";
		String vehiculo="";
		boolean buscar = false;
		while (!buscar){
		System.out.println("Que caracteristicas conoce del ladron?");
		System.out.println("1. Sexo");
		System.out.println("2. Hobby");
		System.out.println("3. Cabello");
		System.out.println("4. Senia");
		System.out.println("5. Vehiculo");
		System.out.println("6. Buscar");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			sexo = this.veoSexo();
		else if (entradaTeclado.equals("2"))
			hobby = this.veoHobby();
		else if (entradaTeclado.equals("3")) 
			pelo = this.veoPelo();
		else if (entradaTeclado.equals("4"))
			senia = this.veoSenia();
		else if (entradaTeclado.equals("5"))
			vehiculo = this.veoVehiculo();
		else if (entradaTeclado.equals("6"))
			buscar = true;
		}
		System.out.println(poli.crearOrdenDeArresto(sexo, hobby, pelo, senia, vehiculo));
		System.out.println(Tiempo.getInstance().fecha());
	}
	
	private String veoPelo(){
		String pelo = "";
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Como era el pelo?");
		System.out.println("1. Rubio");
		System.out.println("2. Negro");
		System.out.println("3. Castanio");
		System.out.println("4. Rojo");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			pelo = "Rubio";
		else if (entradaTeclado.equals("2")) 
			pelo = "Negro";
		else if (entradaTeclado.equals("3"))
			pelo = "Castanio";
		else if (entradaTeclado.equals("4"))
			pelo = "Rojo";
		
		return pelo;
	}
	
	private String veoSexo(){
		String sexo="";
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Cual era el sexo?");
		System.out.println("1. Masculino");
		System.out.println("2. Femenino");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			sexo = "Masculino";
		else if (entradaTeclado.equals("2")) 
			sexo = "Femenino";
		
		return sexo;
	}
	
	private String veoHobby(){
		String hobby = "";
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Cual es su hobby?");
		System.out.println("1. Alpinismo");
		System.out.println("2. Tenis");
		System.out.println("3. Croquet");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			hobby = "Alpinismo";
		else if (entradaTeclado.equals("2")) 
			hobby = "Tenis";
		else if (entradaTeclado.equals("3"))
			hobby = "Croquet";
		
		return hobby;
	}
	
	private String veoSenia(){
		String senia = "";
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Como senia tenia?");
		System.out.println("1. Anillo");
		System.out.println("2. Joyas");
		System.out.println("3. Tatuaje");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			senia = "Anillo";
		else if (entradaTeclado.equals("2")) 
			senia = "Joyas";
		else if (entradaTeclado.equals("3"))
			senia = "Tatuaje";
		
		return senia;
	}
	
	private String veoVehiculo(){
		String vehiculo = "";
		Scanner entradaScanner = new Scanner(System.in);
		System.out.println("Cual es su vehiculo?");
		System.out.println("1. Limusina");
		System.out.println("2. Moto");
		System.out.println("3. Descapotable");
		System.out.println("4. Deportivo");
		String entradaTeclado = entradaScanner.nextLine();
		if (entradaTeclado.equals("1"))
			vehiculo = "Limusina";
		else if (entradaTeclado.equals("2")) 
			vehiculo = "Moto";
		else if (entradaTeclado.equals("3"))
			vehiculo = "Descapotable";
		else if (entradaTeclado.equals("4"))
			vehiculo = "Depotivo";
		
		return vehiculo;
	}
}
