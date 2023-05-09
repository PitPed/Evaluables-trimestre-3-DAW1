package pila;

public interface IPila<T> {
	public void push(T e);
	public T pop();
	public T getFirst();
	public int size();
	public String toString();
}
