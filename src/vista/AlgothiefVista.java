package vista;

import javax.swing.*;

import java.awt.event.*;

public class AlgothiefVista extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	public AlgothiefVista(){
		panel = new JPanel();
		setTitle("Algothienf");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
        panel.setLayout(null);
	}
	
	public void mostrar(){
		setVisible(true);
	}
	
	public String obtenerUsuario(){
		InicioSesion inicio = new InicioSesion(panel);
		return inicio.getUsuario();
	}
	
	public void addAccionBotonInicioSesion(ActionListener accion){
		boton.addActionListener(accion);
	}
	
	
}
