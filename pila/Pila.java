package pila;

public class Pila<T> implements IPila<T>{
	private Nodo primer;
	private int size;
	
	Pila(){
		this.size = 0;
		this.primer = null;
	}
	
	Pila(T[] arr){
		this.size = 0;
		for(Object o: arr)
			this.push(o);
	}
	
	@Override
	public void push(Object e) {
		this.primer = new Nodo(e,primer);
		size++;
	}

	@Override
	public T pop() {
		Object out = null;
		if(primer!=null) {	
			out = primer.getElemento();
			primer = primer.getAnterior();
			size--;
		}
		return (T) out;
	}

	@Override
	public T getFirst() {
		return primer==null?null:(T) primer.getElemento();
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		Nodo<T> aux = primer;
		String out = "";
		while(aux != null) {
			out += aux.getElemento() + "\n";
			aux = aux.getAnterior();
		}
		return out;
	}

}
