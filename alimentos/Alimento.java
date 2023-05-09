package alimentos;

public class Alimento implements Saludable, Comparable<Alimento>{
	private String tipo, nombre;
	private int calorias;
	
	public Alimento(String tipo, String nombre, int calorias) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.calorias = calorias;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

	@Override
	public int getCalorias() {
		return this.calorias;
	}

	@Override
	public String toString() {
		return nombre +"(" + tipo + ")  " + calorias + " calorias";
	}

	@Override
	public int compareTo(Alimento other) {
		int out = this.calorias-other.calorias;
		return out!=0?out:this.getTipo().compareTo(other.getTipo());
	}
	
}

interface Saludable{
	public String getTipo();
	public int getCalorias();
}
