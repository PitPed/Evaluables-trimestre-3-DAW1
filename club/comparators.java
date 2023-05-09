package club;

import java.util.Comparator;
//Compara con la fecha de alta como criterio
class AltaComparator implements Comparator<Socio>{

	@Override
	public int compare(Socio o1, Socio o2) {
		return o1.getfAlta().compareTo(o2.getfAlta());
	}
	
}

//Compara con el nombre como criterio
class NameComparator implements Comparator<Socio>{

	@Override
	public int compare(Socio o1, Socio o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
	
}
//Compara con la fecha de nacimiento como criterio
class BirthComparator implements Comparator<Socio>{

	@Override
	public int compare(Socio o1, Socio o2) {
		return o1.getfNacimiento().compareTo(o2.getfNacimiento());
	}
	
}
