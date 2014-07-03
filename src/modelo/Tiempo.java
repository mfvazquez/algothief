package modelo;

public class Tiempo {
	private int hora;
	private String[] dias;  
	private int dia;
	private static Tiempo INSTANCE = null;
	private int espera;
	
	private Tiempo(){
		this.hora=07;
		this.espera = 0;
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
	
	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Tiempo();
	    }
	}
	
	public static Tiempo getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	public void consumirTiempo (int tiemp){
		espera += tiemp;
	}
	
	public void esperarUnaHora(){
		if (espera == 0 || this.terminoTiempo()){
			espera = 0;
			return;
		}
		this.hora++;
		this.espera--;
		this.veoSiDuerme();
		this.aumentoDia();
		this.hora = this.hora % 24;
	}
	
	public boolean durmiendo(){
		return (this.hora > 23 || this.hora < 7);
	}
	
	public boolean enEspera(){
		return espera > 0;
	}
	
	private void aumentoDia(){
		this.dia = this.dia + this.hora / 24;
	}
	
	private void veoSiDuerme(){
		if (this.hora > 23){
			this.consumirTiempo(8);
		}
	}
	
	public boolean terminoTiempo(){
		if ((this.dia >= 6 && this.hora >=17) || this.dia > 6){
			return true;
		}
		return false;
	}
	
	public String getDia(){
		return this.dias[this.dia];
	}
	
	public int getHora(){
		return this.hora;
	}
	
	public String fecha(){
		String cadena = this.getDia()+" "+this.getHora()+" hs";
		if (this.durmiendo()) cadena += " - Durmiendo";
		return cadena;
	}
	
	public void reiniciar(){
		dia = 0;
		hora = 7;
		espera = 0;
	}
	
	public boolean terminaraUltimoDia(){
		return (dia >= 6 && hora + espera >= 17);
	}
}