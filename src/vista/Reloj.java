package vista;


import javax.swing.JLabel;
import modelo.*;

public class Reloj extends JLabel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	Thread hilo;
	private AlgothiefModelo modelo;

	public Reloj(AlgothiefModelo m, int x, int y, int p, int p1) {
		modelo = m;
		setBounds(x, y, p, p1);
		hilo = new Thread(this);
		hilo.start();
	}

	@ Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();
				
				setText(modelo.getTiempoStr());
				
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		
		}
	
	}
	
	
	public void actualiza() {
		modelo.esperarUnaHora();
	}
	
	public boolean enEspera(){
		return modelo.enEspera();
	}
} 