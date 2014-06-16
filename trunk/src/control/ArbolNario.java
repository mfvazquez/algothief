package control;

import com.gaurav.tree.*;

public class ArbolNario<E> {
	private KAryTree<E> arbol;

	public ArbolNario(int k){
		arbol = new KAryTree<E>(k);
	}
	
	public boolean agregar(E e){
		return arbol.add(e);
	}
	
	public boolean agregar(E padre, E hijo) throws ErrorNodoNoEncontrado {
		try{
			boolean resultado =  arbol.add(padre,hijo);
			return resultado;
		}catch(NodeNotFoundException e){
			throw new ErrorNodoNoEncontrado();
		}
	}
}

