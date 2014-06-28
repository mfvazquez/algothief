package control;

import vista.*;
import modelo.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class AlgothiefControl {
	private AlgothiefVista vista;
	private AlgothiefModelo modelo;
	
	
	public AlgothiefControl(AlgothiefVista nuevaVista, AlgothiefModelo nuevoModelo){
		vista = nuevaVista;
		modelo = nuevoModelo;
		vista.iniciarSesion();
		vista.addAccionBotonInicioSesion(new BotonUsuario());
	}
	
	class BotonUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            modelo.iniciarMision(usuario);
            vista.reiniciarPanel();
            vista.iniciarMision();
            vista.setTiempo(modelo.getTiempoStr());
        }
	}
	
	class BotonMapa implements ActionListener{
		public void actionPerformed(ActionEvent e){
			List<Ciudad> destinos = modelo.getCiudadesDestino();
			vista.mostrarMapa(destinos);
		}
	}
}
