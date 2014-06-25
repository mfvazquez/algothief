package modelo;

public class ObjetoComun extends ObjetoRobado {

	public ObjetoComun(String ciudad) {
		//busca en archivo
		this.objeto = "objeto comun de" + ciudad;
	}

	@Override
	public boolean esObjetoComun() {
		return true;
	}

	@Override
	public boolean esObjetoValioso() {
		return false;
	}

	@Override
	public boolean esObjetoMuyValioso() {
		return false;
	}

}
