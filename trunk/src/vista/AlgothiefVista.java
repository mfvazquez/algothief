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
	private JButton botonOrden;
	
	private ArrayList<JButton> ciudades;
	
	public AlgothiefVista(){
		panel = new JPanel();
		setTitle("Algothienf");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
        panel.setLayout(null);
        
        // inicio
        botonInicioSesion = new JButton("Iniciar Sesion");
        botonInicioSesion.setBounds(300, 425, 200, 25);
        textbox = new JTextField();
        textbox.setBounds(300, 325, 200, 25);
        
        // mision
        tiempo = new JLabel();
        tiempo.setBounds(300, 5, 200, 25);
        botonMapa = new JButton("Mapa");
        botonMapa.setBounds(10, 500, 200, 25);
        botonEdificios = new JButton("Edificios");
    	botonEdificios.setBounds(220, 500, 200, 25);
        botonOrden = new JButton("Orden de Arresto");
    	botonOrden.setBounds(430, 500, 200, 25);
        
        // ciudades
    	ciudades = new ArrayList<JButton>();
        for (int i = 0; i < 3; i++){
        	JButton boton = new JButton();
        	boton.setBounds(10 + i*210, 500, 200, 25);
        	ciudades.add(boton);
        }
	}
	
	public void mostrar(){
		setVisible(true);
	}
	
	public void botonUsuario(ActionListener accion){
		botonInicioSesion.addActionListener(accion);
	}
	
	public void botonMapa(ActionListener accion){
		botonMapa.addActionListener(accion);
	}
	
	public void botonCiudad(ActionListener accion){
		for (int i = 0; i < ciudades.size(); i++){
			JButton boton = ciudades.get(i);
			boton.addActionListener(accion);
		}
	}
	
	public void iniciarSesion(){
        panel.add(botonInicioSesion);
        panel.add(textbox);
        panel.repaint();
	}
	
	public String getUsuario(){
		return textbox.getText();
	}
		
	public void panelGeneral(){
		panel.removeAll();
		panel.add(tiempo);
		panel.add(botonMapa);
		panel.add(botonEdificios);
		panel.add(botonOrden);
		panel.repaint();
	}
	
	public void agregarOpciones(){
		for(int i = 0; i < ciudades.size(); i++){
			panel.add(ciudades.get(i));
		}
	}
	
	public void setTiempo(String fecha){
		tiempo.setText(fecha);
	}
	
	public void mostrarMapa(List<Ciudad> destinos){
		for (int i = 0; i < destinos.size(); i++){
			Ciudad actual = destinos.get(i);
			JButton boton = ciudades.get(i);
			boton.setText(actual.getNombre());
		}
		panel.removeAll();
		this.agregarOpciones();
		panel.add(tiempo);
		panel.repaint();
	}
}