package pila;

public class Nodo<T> {
	private T elemento;
	private Nodo<T> anterior;
	
	Nodo(T e, Nodo<T> a){
		this.elemento = e;
		this.anterior = a;
	}

	public T getElemento() {
		return elemento;
	}

	public Nodo<T> getAnterior() {
		return anterior;
	}
	
	
}
