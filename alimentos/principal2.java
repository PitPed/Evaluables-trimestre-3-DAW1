package alimentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class principal2 {
	static ArrayList<Alimento> alimentos;
	static HashSet<Tipo> tipos = new HashSet<>();
	
	public static void main(String[] args) {
		alimentos = new ArrayList<Alimento>(Arrays.asList(
				new Alimento[] {
				new Alimento("Verdura", "Brocoli", 35),
				new Alimento("Verdura", "Pepino", 15),
				new Alimento("Bolleria", "Baguette", 248),
				new Alimento("Bolleria", "Croissant", 393),
				new Alimento("Lacteo", "Cheddar", 393),
				new Alimento("Lacteo", "Leche", 47),
				new Alimento("Pescado", "Arenque", 143),
				new Alimento("Pescado", "Perca", 111),
				new Alimento("Carne", "Cerdo", 143),
				new Alimento("Carne", "Pavo", 111)
				}));
		
		
		Collections.sort(alimentos);
		for (Alimento a: alimentos) {
			System.out.println(a);
			addTipo(new Tipo(a.getTipo(),a.getCalorias()));
		}
		
		System.out.println(tipos);
	}
	
	public static void addTipo(Tipo t) {
		if(!tipos.add(t)) {
			tipos.stream()
			.filter(e->e.equals(t))
			.findFirst()
			.ifPresent((e)->{e.addCalorias(t.getCalorias());});
		}	
	}
}