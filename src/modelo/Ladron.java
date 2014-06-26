package modelo;

public class Ladron {
	private String nombre;
	private String sexo;
	private String hobby;
	private String cabello;
	private String senia;
	private String vehiculo;
    private RutaDeEscape ruta;

    public Ladron(){
    	nombre = new String();
    	sexo = new String();
    	hobby = new String();
    	cabello = new String();
    	senia = new String();
    	vehiculo = new String();
    }
    
    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo){
    	this.nombre = nombre;
    	this.sexo = sexo;
    	this.hobby = hobby;
    	this.cabello = cabello;
    	this.senia = senia;
    	this.vehiculo = vehiculo;
    }
    
    public Ladron(RutaDeEscape r) {
    //La ruta la crea la mision que conoce el rango del policía
    	this.ruta = r;
    }
    
    public String getNombre(){
    	return this.nombre;
    }
    
    public boolean suSexoEs(String sexo){
    	return (this.sexo.equals(sexo));
    }

    public boolean suHobbyEs(String hobby){
    	return (this.hobby.equals(hobby));
    }

    public boolean suCabelloEs(String pelo){
    	return (this.cabello.equals(pelo));
    }
    
    public boolean suSeniaEs(String senia){
    	return (this.senia.equals(senia));
    }
    
    public boolean suVehiculoEs(String vehiculo){
    	return (this.vehiculo.equals(vehiculo));
    }


}
