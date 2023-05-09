package alimentos;

import java.util.Objects;

public class Tipo implements Comparable<Tipo>{
	private String tipo;
	private int calorias,alimentos;
	
	public Tipo(String tipo, int calorias) {
		this.tipo = tipo;
		this.calorias = calorias;
		this.alimentos = 1;
	}
	
	public void addCalorias(int c) {
		this.calorias += c;
		this.alimentos++;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCalorias() {
		return calorias;
	}
	
	public float getMedia() {
		return this.calorias/this.alimentos;
	}
	
	@Override
	public int compareTo(Tipo other) {
		return this.getTipo().compareTo(other.getTipo());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return Objects.equals(tipo, other.tipo);
	}
	
	@Override
	public String toString() {
		return this.tipo + " Media: " + this.getMedia();
	}
	
	
}
