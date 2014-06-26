package modelo;

public abstract class ObjetoRobado {
	protected String objeto;
	protected String ciudad;
	
	public ObjetoRobado() {
	//el objeto se lee de un archivo
	}
	
	public String getObjeto() {
		return objeto;
	}
	
	public abstract boolean esObjetoComun();
	public abstract boolean esObjetoValioso();
	public abstract boolean esObjetoMuyValioso();
}
