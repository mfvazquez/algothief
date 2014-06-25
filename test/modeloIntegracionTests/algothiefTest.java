package modeloIntegracionTests;

import vista.*;
import control.*;

public class algothiefTest {

	public static void main(String[] args){
		AlgothiefVista vista = new AlgothiefVista();
		AlgothiefControl control = new AlgothiefControl(vista);
		
		vista.mostrar();
	}
	
}
