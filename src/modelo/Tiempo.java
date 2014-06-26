package modelo;

public class Tiempo {
	private int hora;
	private String[] dias;  
	private int dia;
	private static Tiempo INSTANCE = null;
	
	private Tiempo(){
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
		this.hora = hora + tiemp;
		this.veoSiDuerme();
		this.aumentoDia();
		this.hora = this.hora % 24;
	}
	
	public void aumentoDia(){
		this.dia = this.dia + this.hora / 24;
	}
	
	public void veoSiDuerme(){
		if (this.hora >=23){
			this.hora += 8;
		}
	}
	public boolean terminoTiempo(){
		if ((this.dia == 6 && hora >=17) || this.dia > 6){
			return true;
		}else{
			return false;
		}
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
	
	public void reiniciar(){
		dia = 0;
		hora = 7;
	}
}