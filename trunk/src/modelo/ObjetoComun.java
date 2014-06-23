package modelo;

public class ObjetoComun extends ObjetoRobado {

	public ObjetoComun(RangoStrategy rango) {
		super(rango);
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
