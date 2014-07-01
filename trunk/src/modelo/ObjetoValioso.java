package modelo;

public class ObjetoValioso extends ObjetoRobado {

	public ObjetoValioso(String ciudad) {
		super(ciudad, "objetovalioso");
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
