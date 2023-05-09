package pila;

import alimentos.Alimento;

public class principal {

	public static void main(String[] args) {
		Pila<String> p = new Pila<String>(new String[] {"1","2","3"});
		
		System.out.println(p);
		p.pop();
		System.out.println(p);
		
		Pila<Alimento> pilaAlimentos = new Pila<Alimento>(
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
				});
		
		for(int i = pilaAlimentos.size(); i>0;i--)
			System.out.println(pilaAlimentos.pop());
	}

}
