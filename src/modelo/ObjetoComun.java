package modelo;

public class ObjetoComun extends ObjetoRobado {

	public ObjetoComun( String ciudad) {
		//busca en archivo
		//this.objeto = "objeto comun de" + ciudad;
		
	}
		
	//Agrego este constructor para cargar la lista de objetos... no modifico el anterior para q siga funcionando todo
	public ObjetoComun(String objeto, String ciudad){
		this.objeto = objeto;
		this.ciudad = ciudad;
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
