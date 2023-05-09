package instrumentos;

import java.util.Objects;

public class Instrumento implements Comparable<Instrumento> {
	public static enum Clase 
	{
		SIN_CLASE,
		CUERDA,
		PERCUSION,
		VIENTO
	}
	
	private static int ids = 1;
	private int id;
	private String nombre;
	private Clase clase;
	
	public Instrumento() {
		this.id = ids;
		ids++;
		this.nombre = "Sin nombre";
		this.clase = Clase.SIN_CLASE;
	}
	
	public Instrumento(String nombre, Clase clase) {
		this.id = ids;
		ids++;
		this.nombre = nombre;
		this.clase = clase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		Instrumento other = (Instrumento) obj;
		return getClass().equals(other.getClass());
	}
	
	@Override
	public int compareTo(Instrumento other) {
		int out = this.getClase().compareTo(other.getClase());
		if(out == 0)out = this.getNombre().compareTo(other.getNombre());
		return out;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Clase getClase() {
		return clase;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " (" + clase + ")";
	}
	
}
