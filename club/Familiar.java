package club;

import java.io.Serializable;

public class Familiar implements Comparable<Familiar>, Serializable{
	String dni, nombre;
	Fecha fechaNacimiento;
	
	Familiar(String dni, String nombre,Fecha fecha){
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fecha;
	}
	
	@Override
	public int compareTo(Familiar other) {
		return this.fechaNacimiento.compareTo(other.fechaNacimiento);
	}
	
	@Override
	public String toString() {
		String out = "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
		out+= "\nDNI:\t\t\t"+dni;
		out+= "\nNombre:\t\t\t"+nombre;
		out+= "\nFecha de nacimiento\t"+fechaNacimiento;
		return out;
	}
	
}
