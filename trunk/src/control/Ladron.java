package control;

public class Ladron {
	private String nombre;
	private String sexo;
	private String hobby;
	private String cabello;
	private String senia;
	private String vehiculo;
    private RutaDeEscape ruta;
    
    public Ladron(RutaDeEscape r) {
    //La ruta la crea la mision que conoce el rango del policía
    	this.ruta = r;
    }
    
	public void setNombre(String nom) {
		this.nombre = nom;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setSexo(String sex) {
		this.sexo = sex;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setHobby(String hob) {
		this.hobby = hob;
	}

	public String gethobby() {
		return this.hobby;
	}

	public void setCabello(String pelo) {
		this.cabello = pelo;
	}

	public String getCabello() {
		return this.cabello;
	}

	public void setSenia(String sen) {
		this.senia = sen;
	}

	public String getSenia() {
		return this.senia;
	}

	public void setVehiculo(String vehi) {
		this.vehiculo = vehi;
	}

	public String getVehiculo() {
		return this.vehiculo;
	}

}
