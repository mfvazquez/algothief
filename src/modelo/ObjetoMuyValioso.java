package modelo;

public class ObjetoMuyValioso extends ObjetoRobado {

	public ObjetoMuyValioso(String ciudad) {
		//buscar en archivo por ciudad
		this.objeto = "objeto muy valioso de " + ciudad;
	}

	@Override
	public boolean esObjetoComun() {
		return false;
	}

	@Override
	public boolean esObjetoValioso() {
		return false;
	}

	@Override
	public boolean esObjetoMuyValioso() {
		return true;
	}

}
