package main;

import modelo.AlgothiefModelo;
import modelo.ErrorAlCrearElJuego;
import vista.AlgothiefVista;
import control.AlgothiefControl;

public class AlgoThief {
	public static void main(String[] args) throws ErrorAlCrearElJuego{
		AlgothiefModelo modelo = new AlgothiefModelo();
		AlgothiefVista vista = new AlgothiefVista(modelo);
		new AlgothiefControl(vista, modelo);
		vista.mostrar();
	}
}