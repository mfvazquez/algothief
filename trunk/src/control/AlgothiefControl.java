package control;

import vista.*;
import java.awt.event.*;

public class AlgothiefControl {
	private AlgothiefVista vista;
	String usuario;
	
	
	public AlgothiefControl(AlgothiefVista nuevaVista){
		vista = nuevaVista;
		vista.addAccionBoton(new ObtenerUsuario());
	}
	
	class ObtenerUsuario implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.format("\nclic en boton\n");
            usuario = vista.getUsuario();
        }
	}
	
	public String getUsuario(){
		return usuario;
	}
}
