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
	}
	
	class BotonUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            modelo.iniciarMision(usuario);
            vista.panelGeneral();
            vista.setTiempo(modelo.getTiempoStr());
        }
	}
	
	class BotonMapa implements ActionListener{
		public void actionPerformed(ActionEvent e){
			List<Ciudad> destinos = modelo.getCiudadesDestino();
			vista.mostrarMapa(destinos);
		}
	}
	
	class BotonCiudad implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton boton = (JButton) e.getSource();
			String ciudadStr = boton.getText();
			Ciudad ciudad = modelo.getCiudad(ciudadStr);
			modelo.viajar(ciudad);
			vista.setTiempo(modelo.getTiempoStr());
			if (modelo.tiempoTerminado()){
				
			}else{
				vista.panelGeneral();
			}
		}
	}
	
	class BotonEdificio implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class BotonOrden implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
