package control;


public class Tiempo {
	private int hora;
	private String[] dias;  
	private int dia;
	
	
public Tiempo(){
	this.hora=07;
	this.dias = new String[7];
	this.dias [0] = "Lunes";
	this.dias [1] = "Martes";
	this.dias [2] = "Miercoles";
	this.dias [3] = "Jueves";
	this.dias [4] = "Viernes";
	this.dias [5] = "Sabado";
	this.dias [6] = "Domingo";
	this.dia = 0;
}

public void consumirTiempo (int tiemp){
	this.hora = hora + tiemp;
	if (this.hora >= 24){
		this.hora = this.hora - 24;
		this.aumentoDia();
	}
}
public void aumentoDia(){
	this.dia = this.dia +1;
}

public boolean terminoTiempo(){
	if (this.dia == 6 && hora >=17){
		return true;
	}
		else return false;
}


public String getDia(){
	return this.dias[this.dia];
}

public int getHora(){
	return this.hora;
}

public String fecha(){
	String cadena = this.getDia()+" "+this.getHora()+"hs";
	return cadena;
}

}