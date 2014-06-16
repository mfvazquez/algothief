package control;

import com.c05mic.generictree.*;
import java.util.List;
import java.util.ArrayList;

public class Arbol<E> {
	private Tree<E> arbol;

	public Arbol(E raiz){
		arbol = new Tree<E>(new Node<E>(raiz));
	}
	
	public void agregarRaiz(E e){
		arbol.setRoot(new Node<E>(e));
	}
	
	public E verRaiz(){
		return arbol.getRoot().getData();
	}
	
	public boolean agregarHijo(E padre, E hijo){
		Node<E> nodo_padre = arbol.findNode(arbol.getRoot(), padre);
		if (nodo_padre == null) return false;
		nodo_padre.addChild(new Node<E>(hijo));
		return true;
	}
	
	public E verPadre(E hijo){
		Node<E> nodo = arbol.findNode(arbol.getRoot(), hijo);
	    if (nodo == null) return null;
		return nodo.getParent().getData();
	}
	
	public List<E> verHijos(E padre){
		Node<E> nodo = arbol.findNode(arbol.getRoot(), padre);
		if (nodo == null) return null;
		List<E> hijos = new ArrayList<E>();
		for (Node<E> nodo_hijo : nodo.getChildren()){
			hijos.add(nodo_hijo.getData());
		}
		return hijos;
	}
	
}

