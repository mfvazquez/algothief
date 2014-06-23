package modelo;

public class ObjetoValioso extends ObjetoRobado {

	public ObjetoValioso(RangoStrategy rango) {
		super(rango);
		// TODO Auto-generated constructor stub
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
