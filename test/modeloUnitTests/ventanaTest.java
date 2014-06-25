package modeloUnitTests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Rectangle;


public class ventanaTest {
	
	static boolean finalizar;
	static String usuario;
	
	public static void inicio(final JPanel panel){
	    // CREA BOTON
        final JButton continuarBoton = new JButton("viejo");
        continuarBoton.setBounds(50, 60, 80, 30);
        panel.add(continuarBoton);       

        // CREA TEXTBOX
        final JTextField textbox = new JTextField();
        textbox.setBounds(150, 60, 80, 30);
        panel.add(textbox);      

        
     // DEFINE ACCION DE BOTON
        continuarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                panel.remove(continuarBoton);
                panel.remove(textbox);
                panel.revalidate();
                panel.repaint();
                usuario = textbox.getText();
                finalizar = true;
           }
        });
	}
	
	public static void fin(final JPanel panel){
        // CREA TEXTO
        final JLabel texto = new JLabel("Textito");
        texto.setBounds(5, 5, 100, 30);
        panel.add(texto);
        
        // CREA OTRO BOTON
        final JButton nuevo = new JButton("nuevo");
        nuevo.setBounds(100,100,80,30);
        panel.add(nuevo);
        
     // DEFINE ACCION DE BOTON
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
           }
        });
	}
	
	public static void main(String[] args) {
		// CREA VENTANA
		finalizar = false;
		
		JFrame frame = new JFrame();
		frame.setTitle("prueba botones");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
        panel.setLayout(null);

        inicio(panel);
        
        frame.setVisible(true);  
	}
}
