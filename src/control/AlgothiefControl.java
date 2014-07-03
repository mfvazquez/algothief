package control;

import vista.*;
import modelo.*;

import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class AlgothiefControl {
	private AlgothiefVista vista;
	private AlgothiefModelo modelo;
	
	
	public AlgothiefControl(AlgothiefVista nuevaVista, AlgothiefModelo nuevoModelo){
		vista = nuevaVista;
		modelo = nuevoModelo;
		vista.iniciarSesion();
		vista.botonUsuario(new BotonUsuario());
		vista.botonContinuar(new BotonIniciarMision());
		vista.botonMapa(new BotonMapa());
		vista.botonCiudad(new BotonCiudad());
		vista.botonEdificio(new BotonEdificio());
		vista.botonEntrarEdificio(new BotonEntrarEdificio());
		vista.botonOrdenDeArresto(new BotonOrden());
		vista.botonBuscar(new BotonBuscar());
		vista.botonFinalizar(new BotonFinalizar());
		vista.botonCapturar(new BotonCapturar());
	}
	
	class BotonUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            modelo.iniciarMision(usuario);
            vista.inicioMision();
            vista.agregarTextoInicio(usuario +".\n");
            vista.agregarTextoInicio("Policia identificado como " + usuario +".\n");
            vista.agregarTextoInicio("Tu rango es " + modelo.getRango() + ".\n");
            vista.agregarTextoInicio("***NOTICIAS***\n");
            vista.agregarTextoInicio("Tesoro nacional robado en " + modelo.ciudadInicio() + ".\n");
            vista.agregarTextoInicio("El botin ha sido identificado como " + modelo.objetoRobado() + ".\n");
            vista.agregarTextoInicio("Un sospechoso de sexo " + modelo.sexoLadron() + " ha sido visto en el lugar del crimen.\n");
            vista.agregarTextoInicio("Tu mision: perseguir al ladron desde " + modelo.ciudadInicio() + " hasta su escondite y arrestarlo!\n");
        }
	}
	
	class BotonIniciarMision implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Reloj reloj = new Reloj(modelo,vista, 300, 5, 200, 25);
			vista.setReloj(reloj);
			vista.dibujarPanelGeneral();
		}
	}
	
	class BotonMapa implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			List<String> destinos = modelo.getCiudadesDestino();
			vista.mostrarMapa(destinos);
		}
	}
	
	class BotonCiudad implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			JButton boton = (JButton) e.getSource();
			String ciudadStr = boton.getText();
			modelo.viajar(ciudadStr);	
			if (modelo.tiempoTerminado()){
				vista.finalizarMision("Se acabo el tiempo");
				modelo.reiniciar();
			}else{
				vista.dibujarPanelGeneral();
			}
		}
	}
	
	class BotonEdificio implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			mostrarEdificios();
		}
	}
	
	class BotonEntrarEdificio implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			JButton boton = (JButton) e.getSource();
			String edificioStr = boton.getText();
			String pista = modelo.visitarEdificio(edificioStr);
			
			if (modelo.tiempoTerminado()){
				String mensaje = "Superaste el limite de tiempo. Has perdido el rastro del ladron.";
				vista.finalizarMision(mensaje);
				modelo.reiniciar();
			}else if(modelo.ladronCapturado()){
				String direccion = "recursos/"+modelo.armaLadron()+".png";
				vista.capturarLadron(direccion);
			}else{
				vista.mostrarMensaje(pista);
			}
		}
	}
	
	class BotonCapturar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			if(modelo.ladronCapturadoConOrden()){
				String mensaje = "Felicidades. Has capturado a " + modelo.nombreLadronCapturado() + " ";
				vista.finalizarMision(mensaje);
				modelo.aumentarCasosResueltos();
				modelo.reiniciar();
			}else if(modelo.ladronCapturado()){
				String mensaje = "Has capturado a " + modelo.nombreLadronCapturado() + " pero no tienes una orden de arresto. No podemos arrestarlo.";
				vista.finalizarMision(mensaje);
				modelo.reiniciar();
			}
		}
	}
	
	
	class BotonOrden implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			vista.menuOrdenDeArresto();
		}
	}
	
	class BotonBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (vista.enEspera()) return;
			String[] caracteristicasLadron = vista.devolverCaracteristicas();
			String mensaje = modelo.crearOrdenDeArresto(caracteristicasLadron);
			vista.emitirMensaje(mensaje);
			if (modelo.tiempoTerminado()){
				vista.finalizarMision("Se acabo el tiempo");
				modelo.reiniciar();
			}
		}
	}
	
	class BotonFinalizar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vista.iniciarSesion();
		}
	}
	
	
	private void mostrarEdificios(){
		List<String> edificios = modelo.getEdificios();
		vista.mostrarEdificios(edificios);
	}
}
