package control;


import javax.swing.JLabel;

import modelo.*;
import vista.*;

public class Reloj extends JLabel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	Thread hilo;
	private AlgothiefModelo modelo;
	private AlgothiefVista vista;
	private final Object lock = new Object();
	private boolean continuar;
	
	public Reloj(AlgothiefModelo m, AlgothiefVista v, int x, int y, int p, int p1) {
		modelo = m;
		vista = v;
		setBounds(x, y, p, p1);
		hilo = new Thread(this);
		hilo.start();
		continuar = true;
	}

	@ Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == hilo) {
			try {
				actualiza();
				synchronized (lock) {
					if (!continuar) return;
				}
				setText(modelo.getTiempoStr());
				
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		
		}
	
	}
	
	public void actualiza() {
		modelo.esperarUnaHora();
		if (modelo.tiempoTerminado()){
			vista.finalizarMision("Superaste el limite de tiempo. Has perdido el rastro del ladron.");
			try {
				modelo.reiniciar();
			} catch (ArchivoFaltante e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (lock) {
				continuar = false;
			}
		}
	}
	
	public boolean enEspera(){
		return modelo.enEspera();
	}
	
} 