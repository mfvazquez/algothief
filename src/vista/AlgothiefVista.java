package vista;

import javax.swing.*;

import modelo.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;



public class AlgothiefVista extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	private JTextArea texto;
	private JButton botonInicioSesion;
	private JTextField textbox;
	
	private JLabel tiempo;
	
	private JButton botonMapa;
	private JButton botonEdificios;
	private JButton botonOrden;
	
	private ArrayList<JButton> ciudades;
	private JLabel mapaImagen;
	
	private ArrayList<JButton> edificios;
	
	private ArrayList<JComboBox> caracteristicas;
	
	private JTextArea mensaje;
	
	public AlgothiefVista(){
		panel = new JPanel();
		setTitle("Algothienf");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
        panel.setLayout(null);
        
        // inicio
        texto = new JTextArea();
        texto.setBounds(40,40,200, 450);
        texto.setEditable(false);
        texto.setText("Policía al teclado. \nPor favor, identificate: \n");
        texto.setLineWrap(true);
        textbox = new JTextField();
        textbox.setBounds(40, 500, 200, 25);       
        botonInicioSesion = new JButton("OK");
        botonInicioSesion.setBounds(250, 500, 100, 25);
        
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
    	ImageIcon icon = new ImageIcon("recursos/mapa.png");
    	Image img = icon.getImage();
    	Image aux = img.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
		mapaImagen = new JLabel(new ImageIcon(aux));
		mapaImagen.setBounds(20,50,600,400);
    	
    	ciudades = new ArrayList<JButton>();
        for (int i = 0; i < 3; i++){
        	JButton boton = new JButton();
        	boton.setBounds(625, 50+150*i, 150, 25);
        	ciudades.add(boton);
        }
        
        // edificios
    	edificios = new ArrayList<JButton>();
        for (int i = 0; i < 3; i++){
        	JButton boton = new JButton();
        	boton.setBounds(575, 50+150*i, 200, 25);
        	edificios.add(boton);
        }
        
        // Mostar Pista
        mensaje = new JTextArea();
        mensaje.setLineWrap(true);
        mensaje.setBounds(40,40,300, 450);
        
        // Orden de Arresto
       caracteristicas = new  ArrayList<JComboBox>();
        for (int i = 0; i < 5; i++){
        	JComboBox combobox = new JComboBox();
        	combobox.setBounds(625, 50+50*i, 200, 25);
        	caracteristicas.add(combobox);
        }
	}
	
	public void mostrar(){
		setVisible(true);
	}
	
	public void botonUsuario(ActionListener accion){
		botonInicioSesion.addActionListener(accion);
	}
	
	public void reemplazarBotonUsuario(ActionListener accion){
		ActionListener[] acciones = botonInicioSesion.getActionListeners();
		botonInicioSesion.removeActionListener(acciones[0]);
		botonInicioSesion.addActionListener(accion);
	}
	
	public void agregarTextoInicio(String nuevoTexto){
		String textoCompleto = texto.getText() + nuevoTexto;
		texto.setText(textoCompleto);
	}
	
	public void botonMapa(ActionListener accion){
		botonMapa.addActionListener(accion);
	}
	
	public void botonCiudad(ActionListener accion){
		agregarAccionOpciones(accion, ciudades);
	}
	
	public void botonEdificio(ActionListener accion){
		botonEdificios.addActionListener(accion);
	}
	
	public void botonEntrarEdificio(ActionListener accion){
		agregarAccionOpciones(accion, edificios);
	}
	
	private void agregarAccionOpciones(ActionListener accion, List<JButton> botones){
		for (int i = 0; i < botones.size(); i++){
			JButton boton = botones.get(i);
			boton.addActionListener(accion);
		}
	}
	
	public void iniciarSesion(){
        panel.add(botonInicioSesion);
        panel.add(textbox);
        panel.add(texto);
        panel.repaint();
	}
	
	public String getUsuario(){
		return textbox.getText();
	}
		
	private void agregarPanelGeneral(){
		panel.add(tiempo);
		panel.add(botonMapa);
		panel.add(botonEdificios);
		panel.add(botonOrden);
	}
	
	private void agregarOpciones(List<JButton> botones ){
		for(int i = 0; i < botones.size(); i++){
			panel.add(botones.get(i));
		}
	}
	
	public void setTiempo(String fecha){
		tiempo.setText(fecha);
	}
	
	public void mostrarMapa(List<String> destinos){
		for (int i = 0; i < destinos.size(); i++){
			JButton boton = ciudades.get(i);
			boton.setText(destinos.get(i));
		}
		panel.removeAll();
		this.agregarOpciones(ciudades);
		agregarPanelGeneral();

		panel.add(mapaImagen);
		panel.repaint();
	}
	
	public void mostrarEdificios(List<String> destinos){
		for (int i = 0; i < destinos.size(); i++){
			JButton boton = edificios.get(i);
			boton.setText(destinos.get(i));
		}
		panel.removeAll();
		this.agregarOpciones(edificios);
		agregarPanelGeneral();
		panel.repaint();
	}
	
	public void mostrarMensaje(String mensajeStr){
		mensaje.setText(mensajeStr);
		panel.removeAll();
		agregarPanelGeneral();
		panel.add(mensaje);
		panel.repaint();
	}
	
	public void dibujarPanelGeneral(){
		panel.removeAll();
		agregarPanelGeneral();
		panel.repaint();
	}
	
}
