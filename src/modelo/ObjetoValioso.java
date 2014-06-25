package modelo;

public class ObjetoValioso extends ObjetoRobado {

	public ObjetoValioso(String ciudad) {
		//buscar en archivo de acuerdo a la ciudad
		this.objeto = "objeto valioso de " + ciudad;
	}

	@Override
	public boolean esObjetoComun() {
		return false;
	}

	@Override
	public boolean esObjetoValioso() {
		return true;
	}

	@Override
	public boolean esObjetoMuyValioso() {
		return false;
	}

}
