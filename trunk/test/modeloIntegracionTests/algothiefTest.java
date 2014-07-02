package modeloIntegracionTests;

import modelo.*;
import vista.*;
import control.*;

public class algothiefTest {

	public static void main(String[] args){
		AlgothiefModelo modelo = new AlgothiefModelo();
		AlgothiefVista vista = new AlgothiefVista(modelo);
		new AlgothiefControl(vista, modelo);
		vista.mostrar();
	}
	
}
