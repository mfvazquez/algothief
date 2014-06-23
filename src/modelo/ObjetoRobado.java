package modelo;

public abstract class ObjetoRobado {
	private String objeto;
	
	public ObjetoRobado(RangoStrategy rango) {
	//el objeto se lee de un archivo
	}
	
	public String getObjeto() {
		return objeto;
	}
	
	public abstract boolean esObjetoComun();
	public abstract boolean esObjetoValioso();
	public abstract boolean esObjetoMuyValioso();
}
