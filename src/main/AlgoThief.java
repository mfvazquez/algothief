package main;

import modelo.AlgothiefModelo;
import vista.AlgothiefVista;
import control.AlgothiefControl;

public class AlgoThief {
	public static void main(String[] args){
		AlgothiefModelo modelo = new AlgothiefModelo();
		AlgothiefVista vista = new AlgothiefVista(modelo);
		new AlgothiefControl(vista, modelo);
		vista.mostrar();
	}
}