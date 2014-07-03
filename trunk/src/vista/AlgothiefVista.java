package vista;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import modelo.*;
import control.*;


public class AlgothiefVista extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	private JTextArea texto;
	
	private Reloj reloj;
	
	private JButton botonUsuario;
	private JButton botonContinuar;
	private JTextField textbox;
	
	private JButton botonMapa;
	private JButton botonEdificios;
	private JButton botonOrden;
	
	private ArrayList<JButton> ciudades;
	private JLabel mapaImagen;
	
	private ArrayList<JButton> edificios;
	private JLabel testigoImagen;
	
	private ArrayList<JLabel> tipoCaracteristica;
	private ArrayList<JComboBox<String>> caracteristicas;
	private JButton botonBuscar;
	
	private JButton botonCapturar;
	
	private JTextArea mensaje;
	
	private JButton botonFinalizar;
	
	public AlgothiefVista(AlgothiefModelo modelo){
		panel = new JPanel();
		setTitle("Algothief");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
        panel.setLayout(null);
        
        reloj = null;
        
        // inicio
        texto = new JTextArea();
        texto.setBounds(40,40,360, 450);
        texto.setEditable(false);
        texto.setLineWrap(true);
        textbox = new JTextField();
        textbox.setBounds(40, 500, 200, 25);       
        botonUsuario = new JButton("Ingresar");
        botonUsuario.setBounds(250, 500, 150, 25);
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(250, 500, 150, 25);
        
        // mision
        botonMapa = new JButton("Mapa");
        botonMapa.setBounds(50, 500, 200, 25);
        botonEdificios = new JButton("Edificios");
    	botonEdificios.setBounds(300, 500, 200, 25);
        botonOrden = new JButton("Orden de Arresto");
    	botonOrden.setBounds(550, 500, 200, 25);
        
        // ciudades
    	mapaImagen = cargarImagen("recursos/mapa.png", 600, 400);
		mapaImagen.setBounds(20,50,600,400);    	
		
    	ciudades = new ArrayList<JButton>();
        for (int i = 0; i < 3; i++){
        	JButton boton = new JButton();
        	boton.setBounds(625, 50+187*i, 150, 25);
        	ciudades.add(boton);
        }
        
        // edificios
    	testigoImagen = cargarImagen("recursos/testigo.png", 300, 400);
        testigoImagen.setBounds(400,40,400,450);    	
        
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
        tipoCaracteristica = new ArrayList<JLabel>();
        tipoCaracteristica.add(new JLabel("Sexo:"));
        tipoCaracteristica.add(new JLabel("Hobby:"));
        tipoCaracteristica.add(new JLabel("Cabello:"));
        tipoCaracteristica.add(new JLabel("Senia:"));
        tipoCaracteristica.add(new JLabel("Vehiculo:"));
        String[] sexo = {"","Masculino", "Femenino"};
        String[] hobby = {"","Alpinismo", "Tenis", "Croquet"};
        String[] cabello = {"","Rubio","Negro","Castanio","Rojo"};
        String[] senia = {"","Anillo","Joyas","Tatuaje"};
        String[] vehiculo = {"","Limusina","Moto","Descapotable","Deportivo"};
        String[][] caracteristicasStr = {sexo, hobby, cabello, senia, vehiculo};        
        caracteristicas = new  ArrayList<JComboBox<String>>(); 
        for (int i = 0; i < 5; i++){
    	   JComboBox<String> combobox = new JComboBox<String>(caracteristicasStr[i]);
    	   combobox.setBounds(575, 50+75*i, 200, 25);   	   
    	   caracteristicas.add(combobox);
    	   JLabel label = tipoCaracteristica.get(i);
    	   label.setBounds(500, 50+75*i, 75, 25);
        }
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(575,425, 200, 25 );
        
        botonFinalizar = new JButton("Finalizar");
        botonFinalizar.setBounds(40, 500, 200, 25);
        
        botonCapturar = new JButton("Capturar");
        botonCapturar.setBounds(350, 525, 100, 25);

	}
	
	public JLabel cargarImagen(String direccion, int ancho, int alto){
		ImageIcon icon = new ImageIcon(direccion);
    	Image img = icon.getImage();
    	Image aux = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new JLabel(new ImageIcon(aux));    	
	}
	
	public void setReloj(Reloj r){
		reloj = r;
		panel.add(reloj);
	}
	
	public void mostrar(){
		setVisible(true);
	}
	
	public void botonUsuario(ActionListener accion){
		botonUsuario.addActionListener(accion);
	}
	
	public void botonCapturar(ActionListener accion){
		botonCapturar.addActionListener(accion);
	}
	
	public void botonContinuar(ActionListener accion){
		botonContinuar.addActionListener(accion);
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
	
	public void botonOrdenDeArresto(ActionListener accion){
		botonOrden.addActionListener(accion);
	}
	
	public void botonBuscar(ActionListener accion){
		botonBuscar.addActionListener(accion);
	}
	
	public void botonFinalizar(ActionListener accion){
		botonFinalizar.addActionListener(accion);
	}
	
	private void agregarAccionOpciones(ActionListener accion, List<JButton> botones){
		for (int i = 0; i < botones.size(); i++){
			JButton boton = botones.get(i);
			boton.addActionListener(accion);
		}
	}
	
	public void iniciarSesion(){
		panel.removeAll();
        panel.add(botonUsuario);
        panel.add(textbox);
        panel.add(texto);
        texto.setText("Policía al teclado. \nPor favor, identificate: \n");
        panel.repaint();
	}
	
	public void inicioMision(){
		panel.removeAll();
		panel.add(botonContinuar);
		panel.add(texto);
		panel.repaint();
	}
	
	public String getUsuario(){
		return textbox.getText();
	}
		
	private void agregarPanelGeneral(){
		panel.add(reloj);
		panel.add(botonMapa);
		panel.add(botonEdificios);
		panel.add(botonOrden);
	}
	
	private void agregarOpciones(List<JButton> botones ){
		for(int i = 0; i < botones.size(); i++){
			panel.add(botones.get(i));
		}
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
		panel.add(testigoImagen);
		panel.add(mensaje);
		panel.repaint();
	}
	
	public void dibujarPanelGeneral(){
		panel.removeAll();
		agregarPanelGeneral();
		panel.repaint();
	}
	
	public void menuOrdenDeArresto(){
		panel.removeAll();
		for (int i = 0; i < caracteristicas.size(); i++){
			JComboBox<String> aux = caracteristicas.get(i);
			panel.add(aux,BorderLayout.NORTH);
			JLabel label = tipoCaracteristica.get(i);
			panel.add(label);
		}
		panel.setBorder(BorderFactory.createEmptyBorder(0,0,800,600));
		agregarPanelGeneral();
		panel.add(botonBuscar);
		emitirMensaje("");
		panel.repaint();
	}
	
	public String[] devolverCaracteristicas(){		
		ArrayList<String> lista = new ArrayList<String>();
		for (int i = 0; i < 5; i++){
			lista.add(caracteristicas.get(i).getSelectedItem().toString());
		}
		return lista.toArray(new String[0]);
	}
	
	public void emitirMensaje(String mensaje){
		texto.setText(mensaje);
		panel.add(texto);
	}
	
	public void finalizarMision(String mensaje){
		panel.removeAll();
		emitirMensaje(mensaje);
		panel.add(botonFinalizar);
		panel.repaint();
	}

	public void capturarLadron(String imagenDir){
		panel.removeAll();
		panel.add(reloj);
		JLabel armaImagen = cargarImagen(imagenDir, 600, 400);
        armaImagen.setBounds(100,100,600,400);
        panel.add(armaImagen);
		panel.add(botonCapturar);
		panel.repaint();
	}
	
	public boolean enEspera(){
		return reloj.enEspera();
	}
}
