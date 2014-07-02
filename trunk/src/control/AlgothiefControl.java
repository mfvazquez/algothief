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
		vista.botonMapa(new BotonMapa());
		vista.botonCiudad(new BotonCiudad());
		vista.botonEdificio(new BotonEdificio());
		vista.botonEntrarEdificio(new BotonEntrarEdificio());
		vista.botonOrdenDeArresto(new BotonOrden());
	}
	
	class BotonUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            modelo.iniciarMision(usuario);
            vista.reemplazarBotonUsuario(new BotonIniciarMision());
            vista.agregarTextoInicio(usuario +".\n");
            vista.agregarTextoInicio("Policia identificado como " + usuario +".\n");
            vista.agregarTextoInicio("Tu rango es " + modelo.getRango() + ". ");
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
				// BLOQUEAR TODO Y ANUNCIAR QUE SE ACABO EL TIEMPO
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
				
			}else{
				vista.mostrarMensaje(pista);
	//			vista.panelGeneral();
			}
		}
	}
	
	class BotonOrden implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vista.menuOrdenDeArresto();
		}
	}
	
	private void mostrarEdificios(){
		List<String> edificios = modelo.getEdificios();
		vista.mostrarEdificios(edificios);
	}
}
