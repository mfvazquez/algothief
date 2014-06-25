package vista;

import javax.swing.*;

import java.awt.event.*;

public class InicioSesion {

	private JButton boton;
	private JTextField textbox;
	
	public InicioSesion(JPanel panel){
		
		boton = new JButton("Iniciar Sesion");
        boton.setBounds(300, 425, 200, 25);
        panel.add(boton);       
        
        textbox = new JTextField();
        textbox.setBounds(300, 325, 200, 25);
        panel.add(textbox);
	}
	
	public void addAccionBoton(ActionListener accion){
		boton.addActionListener(accion);
	}
	
	public String getUsuario(){
		return textbox.getText();
	}
	
}
