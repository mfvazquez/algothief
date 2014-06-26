package modeloIntegracionTests;

import modelo.*;
import vista.*;
import control.*;

public class algothiefTest {

	public static void main(String[] args){
		AlgothiefVista vista = new AlgothiefVista();
		AlgothiefModelo modelo = new AlgothiefModelo();
		AlgothiefControl control = new AlgothiefControl(vista, modelo);
		vista.mostrar();
	}
	
}
