package club;

import java.util.Scanner;
//Una clase a la que se le introduce un array de enunciados
//Los lista y solicita al usuario una respuesta de manera iterativa
//Gestiona excepciones y permite salir del menu
public class Menu {
	String[] enunciados;
	
	public Menu(String[] enun) throws Exception{
		if (enun.length>0)
			enunciados = enun;
		else 
			throw(new Exception("El menu debe tener al menos una opcion"));
	}
	

	//El metodo principal del menu que devuelve la opcion elegida por el usuario
	//Si el usuario decide salir del menu devuelve -1
	public int menu() {
		mostrarMenu();
		return solicitarOpcion();
	}
	
	private void mostrarMenu() {
		int i = 1;
		for (String enunciado : enunciados) {
			System.out.println(i + ".\t"+enunciado);
			i++;
		}
		System.out.println(i + ".\tSalir");
	}
	
	private int solicitarOpcion() {
		boolean correcto = false;
		int option = 0;
		
		while (correcto == false) {
			Scanner sc = new Scanner(System.in);
			try {
				option = sc.nextInt();
			}catch(Exception e) {
				System.out.println("El valor introducido debe ser un numero");
			}
			
			if(option<1 || option>enunciados.length) {
				if(option==enunciados.length+1) {
					option = -1;
					correcto=true;
				}
				else System.out.println("Opcion no valida(vuelve a intentarlo)");
			}else
				correcto = true;
		
		
		}
		return option;
	}
}
