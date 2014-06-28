package vista;

import javax.swing.*;
import modelo.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class AlgothiefVista extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	private JButton botonInicioSesion;
	private JTextField textbox;
	
	private JLabel tiempo;
	
	private JButton botonMapa;
	private JButton botonEdificios;
	private JButton botonOrdenDeArresto;
	
	private ArrayList<JButton> opciones;
	
	public AlgothiefVista(){
		panel = new JPanel();
		setTitle("Algothienf");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
        panel.setLayout(null);
	}
	
	public void iniciarSesion(){
        botonInicioSesion = new JButton("Iniciar Sesion");
        botonInicioSesion.setBounds(300, 425, 200, 25);
        panel.add(botonInicioSesion);       
        
        textbox = new JTextField();
        textbox.setBounds(300, 325, 200, 25);
        panel.add(textbox);
        panel.repaint();
	}
	
	public void reiniciarPanel(){
		panel.removeAll();
	}
	
	public void mostrar(){
		setVisible(true);
	}
	
	public void addAccionBotonInicioSesion(ActionListener accion){
		botonInicioSesion.addActionListener(accion);
	}
	
	public String getUsuario(){
		return textbox.getText();
	}
	
	public void iniciarMision(){
		tiempo = new JLabel();
		tiempo.setBounds(300, 5, 200, 25);
		panel.add(tiempo);
		
		botonMapa = new JButton("Mapa");
		botonMapa.setBounds(10, 500, 200, 25);
		panel.add(botonMapa);
		
		botonEdificios = new JButton("Explorar Ciudad");
		botonEdificios.setBounds(220, 500, 200, 25);
		panel.add(botonEdificios);
		
		botonOrdenDeArresto = new JButton("Orden de Arrestro");
		botonOrdenDeArresto.setBounds(430, 500, 200, 25);
		panel.add(botonOrdenDeArresto);
		
		panel.repaint();
	}
	
	public void setTiempo(String fecha){ // deberia lanzar excepcion si tiempo no existe
		tiempo.setText(fecha);
	}
	
	public void mostrarMapa(List<Ciudad> destinos){
		
	}
}
