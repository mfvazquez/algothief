package control;

import vista.*;
import modelo.*;
import java.awt.event.*;

public class AlgothiefControl {
	private AlgothiefVista vista;
	private AlgothiefModelo modelo;
	
	
	public AlgothiefControl(AlgothiefVista nuevaVista, AlgothiefModelo nuevoModelo){
		vista = nuevaVista;
		modelo = nuevoModelo;
		vista.iniciarSesion();
		vista.addAccionBotonInicioSesion(new ObtenerUsuario());
	}
	
	class ObtenerUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            modelo.iniciarMision(usuario);
            vista.reiniciarPanel();
            vista.iniciarMision();
            vista.setTiempo(modelo.getTiempoStr());
        }
	}
}
