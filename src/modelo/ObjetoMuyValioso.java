package modelo;

public class ObjetoMuyValioso extends ObjetoRobado {

	public ObjetoMuyValioso(String ciudad) {
		super(ciudad, "objetomuyvalioso");
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
