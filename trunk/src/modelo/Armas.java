package modelo;

import java.util.ArrayList;

public class Armas {
	private int armaElegida;
	private ArrayList<Arma> armas;
	
	public Armas(){
		armas = new ArrayList<Arma>();
		armas.add(new Arma("cuchillo", 2));
		armas.add(new Arma("pistola", 4));	
		Double aux = Math.floor(Math.random()*armas.size());
		armaElegida = aux.intValue();
	}
	
	public int getDemora(){
		return armas.get(armaElegida).getDemora();
	}
	
	public String getArma(){
		return armas.get(armaElegida).getNombre();
	}
}
