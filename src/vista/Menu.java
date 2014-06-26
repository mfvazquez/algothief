package vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.Rectangle;

import java.awt.event.*;

public class Menu {
	private ArrayList<JButton> botones;
	private Rectangle ubicacion;
	
	
	public Menu(Rectangle pos){
		botones = new ArrayList<JButton>();
		ubicacion = pos;
	}
	
	public void agregarBoton(String nombre, ActionListener accion){
		JButton aux = new JButton(nombre);
		
	}
}
