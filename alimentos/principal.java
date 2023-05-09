package alimentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import alimentos.comparators.ComparatorTipo;

public class principal {
	static ArrayList<Alimento> alimentos;
	static ArrayList<Tipo> tipos = new ArrayList<>();
	
	public static void main(String[] args) {
		alimentos = new ArrayList<Alimento>(Arrays.asList(
				new Alimento[] {
				new Alimento("Verdura", "Brocoli", 35),
				new Alimento("Verdura", "Pepino", 15),
				new Alimento("Verdura", "Tomate", 47),
				new Alimento("Panes", "Baguette", 248),
				new Alimento("Panes", "Croissant", 393),
				new Alimento("Lacteo", "Cheddar", 393),
				new Alimento("Lacteo", "Leche", 47),
				new Alimento("Pescado", "Arenque", 143),
				new Alimento("Pescado", "Perca", 111),
				new Alimento("Carne", "Cerdo", 143),
				new Alimento("Carne", "Pavo", 111)
				}));
		
		
		Collections.sort(alimentos, new ComparatorTipo());
		
		for (Alimento a: alimentos) {
			System.out.println(a);
			addTipo(new Tipo(a.getTipo(),a.getCalorias()));
		}
		
		listado();
		
	}
	
	public static void addTipo(Tipo t) {
		Collections.sort(tipos);
		
		tipos.stream()
		.filter(tipo->tipo.equals(t))
		.findFirst()
		.ifPresentOrElse(
				(e)->{e.addCalorias(t.getCalorias());},
				()->{tipos.add(t);});
		
		/*int pos = Collections.binarySearch(tipos, t);
		if (pos>=0)
			tipos.get(pos).addCalorias(t.getCalorias());
		else
			tipos.add(t);*/
		
		/*boolean exists = tipos.contains(t);
		
		if (exists)
			tipos.stream()
			.filter(tipo->tipo.equals(t))
			.findAny()
			.ifPresent(e->e.addCalorias(t.getCalorias()));
		else
			tipos.add(t);*/
		
		

		

		
	}
	
	public static void listado() {
		System.out.println("\nListado de tipos y su media de calorias\n");
		for (Tipo t: tipos)
			System.out.println("Tipo:\t"+t.getTipo()+"\tMedia calorias:\t"+t.getCalorias());
	}

}
