package control;

import vista.*;
import modelo.*;

import java.awt.event.*;
import java.util.ArrayList;
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
			vista.dibujarPanelGeneral();
            vista.setTiempo(modelo.getTiempoStr());
		}
	}
	
	class BotonMapa implements ActionListener{
		public void actionPerformed(ActionEvent e){
			List<String> destinos = modelo.getCiudadesDestino();
			vista.mostrarMapa(destinos);
		}
	}
	
	class BotonCiudad implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton boton = (JButton) e.getSource();
			String ciudadStr = boton.getText();
			modelo.viajar(ciudadStr);	
			vista.setTiempo(modelo.getTiempoStr());
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
			mostrarEdificios();
		}
	}
	
	class BotonEntrarEdificio implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton boton = (JButton) e.getSource();
			String edificioStr = boton.getText();
			String pista = modelo.visitarEdificio(edificioStr);
			
			vista.setTiempo(modelo.getTiempoStr());
			if (modelo.tiempoTerminado()){
				vista.finalizarMision("Se acabó el tiempo");
			}else if(modelo.ladronCapturadoConOrden()){
				vista.finalizarMision("Ladron Capturado");
				modelo.reiniciar();
				vista.setTiempo(modelo.getTiempoStr());
			}else{
				vista.mostrarMensaje(pista);
			}
		}
	}
	
	class BotonOrden implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vista.menuOrdenDeArresto();
		}
	}
	
	class BotonBuscar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String[] caracteristicasLadron = vista.devolverCaracteristicas();
			String mensaje = modelo.crearOrdenDeArresto(caracteristicasLadron);
			vista.emitirMensaje(mensaje);
			vista.setTiempo(modelo.getTiempoStr());
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
