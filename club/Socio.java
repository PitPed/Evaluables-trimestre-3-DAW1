package club;

import java.io.Serializable;
import java.util.Arrays;

public class Socio implements Comparable<Socio>, Serializable{
	private static int ids = 1;
	private int nSocio;
	String nombre, tlf, email;
	Fecha fNacimiento, fAlta;
	Familiar[] familiares;
	
	
	Socio(int nSocio){
		this.nSocio = nSocio;
	}
	
	//Constructor que inicializa los atributos
	public Socio(String nombre, String tlf, String email, Fecha fNacimiento) throws Exception{
		setNombre(nombre);
		setTlf(tlf);
		setEmail(email);
		this.fNacimiento = fNacimiento;
		this.fAlta = new Fecha();
		this.nSocio = ids;
		this.familiares = new Familiar[0];
		ids++;
	}
	
	
	
	//Getters por defecto
	public int getnSocio() {
		return nSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTlf() {
		return tlf;
	}
	public String getEmail() {
		return email;
	}
	public Fecha getfNacimiento() {
		return fNacimiento;
	}
	public Fecha getfAlta() {
		return fAlta;
	}



	//Getters con restricciones
	public void setNombre(String nombre) throws Exception{
		if(nombre.length()<1||nombre.length()>30)
			throw(new Exception("El nombre debe tener entre 1 y 30 caracteres"));
		this.nombre = nombre;
	}
	
	public void setTlf(String tlf) throws Exception{	
		this.tlf = tlf;
	}
	
	public void setTlfConExcepcion(String tlf) throws Exception{
		if(tlf.length()<9||tlf.length()>15)
			throw(new Exception("El telefono debe tener entre 9 y 15 caracteres"));
		else
			for(char c : tlf.toCharArray())
				if (c<'0'|c>'9')
					throw(new Exception("El telefono solo puede contener numeros"));
		
		this.tlf = tlf;
	}
	
	public void setEmail(String email) throws Exception {
		if(email.length()<1||email.length()>30)
			throw(new Exception("El nombre debe tener entre 1 y 30 caracteres"));
		this.email = email;
	}
	
	
	public void nuevoFamiliar(Familiar f) {
		familiares = Arrays.copyOf(familiares, familiares.length+1);
		familiares[familiares.length-1]=f;
	}
	
	
	//Para "eliminar" un socio se fija su id a -1
	//Al introducir nuevos socios al array se comprueba si hay alguno inactivo
	//En ese caso se reemplaza el incativo por el nuevo
	public void setInactive() {
		this.nSocio = -1;
	}
	
	@Override
	public String toString() {
		String out = "__________________________________";
		out+="\nNumero de Socio:\t"+nSocio;
		out+="\nNombre:\t\t\t"+nombre;
		out+="\nTelefono:\t\t"+tlf;
		out+="\nEmail:\t\t\t"+email;
		out+="\nFecha de alta:\t\t"+fAlta;
		out+="\nFecha de nacimiento:\t"+fNacimiento;
		if(familiares.length>0) {
			out+="\nFamiliares:\n";
			for(Familiar f: familiares)
				out+=f+"\n";
		}
		return out;
	}




	@Override
	public int compareTo(Socio other) {
		return this.getnSocio()-other.getnSocio();
	}
	
	
	
	
}