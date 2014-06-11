package tpfinalalgo3;

import java.util.LinkedList;

public class Ciudad {
	private String nombre;
	private LinkedList<Edificio> edificios;
	
	public void setEdificio(Edificio edi){
		this.edificios.addLast(edi); 
	}
	public Edificio getEdificioNro(int nro){
		return this.edificios.get(nro);
	}
	public void setNombre(String nom){
		this.nombre=nom;
	}
	public String getNombre(){
		return this.nombre;
	}

}
