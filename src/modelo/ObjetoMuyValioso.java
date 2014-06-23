package modelo;

public class ObjetoMuyValioso extends ObjetoRobado {

	public ObjetoMuyValioso(RangoStrategy rango) {
		super(rango);
		// TODO Auto-generated constructor stub
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
