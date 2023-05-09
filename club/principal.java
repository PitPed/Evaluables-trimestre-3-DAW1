package club;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class principal {
	static Socio[] socios = {};
	static Menu menuPrincipal = null;
	static Menu menuListarSocios = null;
	static Menu menuSocio = null;
	

	public static void main(String[] args) throws Exception{
		final String FICHERO_DE_GUARDADO = "socios.dat";
		
		/*socios = new Socio[] {
				
				new Socio("Enok", "912345678", "enok@email.com",new Fecha(1,12,1942)),
				new Socio("Dani", "912345678", "dani@email.com",new Fecha(2,11,1952)),
				new Socio("Fede", "954912387", "fede@email.com",new Fecha(3,10,1992)),
				new Socio("Alex", "987654321", "alex@email.com",new Fecha(4,9,1982)),
				new Socio("Ceci", "932165487", "ceci@email.com",new Fecha(5,8,1962)),
				new Socio("Bill", "965432187", "bill@email.com",new Fecha(6,7,1972))
				
		};*/
		
		
		try {
			socios = (Socio[]) leerObjeto(FICHERO_DE_GUARDADO);
		}catch(EOFException e) {
			System.out.println("El archivo esta vacio");
			System.out.println("Continuando con la lista de socios vacia");
		}catch(Exception e){
			System.out.println("Error al leer el archivo(" + e +")");
			System.out.println("Continuando con la lista de socios vacia");
		}
		
		//Genero los menus
		try {
			menuPrincipal = new Menu(new String[] {"Listar Socios","Nuevo Socio","Opciones de socio"});
			menuListarSocios = new Menu(new String[] {"Ordenar por fecha de alta","Ordenar alfabeticamente","Ordenar por fecha de nacimiento"});
			menuSocio = new Menu(new String[] {"Mostrar Socio", "Editar telefono", "Agregar Familiar", "Borrar Socio"});
		}catch(Exception e) {
			System.out.println("Error al crear los menus: "+e);
		}
			
		int respuestaPrincipal;
		//Itero sobre el menu principal
		do {
			respuestaPrincipal = menuPrincipal.menu();
			//Se hace algo según lo que el usuario responda al menú
			switch (respuestaPrincipal) {
				//La primera opcion abre el submenu de listarSocios
				case 1-> {
					if(socios.length>0) {
						switch (menuListarSocios.menu()){
							case 1 ->listarSocios(new AltaComparator());
							case 2 ->listarSocios(new NameComparator());
							case 3 ->listarSocios(new BirthComparator());
						}
					}else
						System.out.println("Introduce socios para usar este menu");
				}
				//La segunda opcion solicita los datos para instanciar un nuevo socio
				case 2->nuevoSocio(solicitarSocio());
				//La tercera opcion abre el submenu de socio para editarlo o visualizarlo
				case 3->{
					if(socios.length>0) {
						int respuestaSocio;
						Socio socioActivo = seleccionarSocio();
						if (socioActivo==null)
							respuestaSocio=-1;
						else {
							do {
								System.out.println("Socio seleccionado: Numero de socio "+socioActivo.getnSocio());
								respuestaSocio = menuSocio.menu();
								switch (respuestaSocio) {
									case 1-> System.out.println(socioActivo);
									case 2-> {
										boolean correcto = false;
										do {	
											try {
												socioActivo.setTlf(solicitarString("Introduce el nuevo telefono (entre 9-15 caracteres)"));
												correcto=true;
											}	
											catch (Exception e) {
												System.out.println(e);
											}
										}while(correcto==false);
									}
									case 3->socioActivo.nuevoFamiliar(solicitarFamiliar());
									case 4->{
										socioActivo.setInactive();
										System.out.println("Socio eliminado");
										respuestaSocio=-1;
										}
									}
								}while(respuestaSocio>0);
							}
						}else
							System.out.println("Introduce socios para usar este menu");
					}
				}
			
			
		}while(respuestaPrincipal>0);
		//Al terminar de ejecutarse pregunta si se quieren guardar los cambios
		if(solicitarInt("Quieres guardar los cambios?\n 1.\t Si\n 2.\t No\n", 1, 2)==1) {
			try {
				guardarObjeto(FICHERO_DE_GUARDADO, socios);
				System.out.println("Cambios guardados");
			}catch (Exception e) {
				System.out.println("Error al guardar en el archivo (archivo no guardado)");
			}
			
		}
		System.out.println("Saliendo...");
	}
	
	
	//Solicita ints de manera recursiva y gestiona las excepciones
	private static int solicitarInt(String pregunta, int min, int max) {
		String rango = min+" - "+max;
		int out = 0;
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(pregunta + "("+rango+")");
			try {
				out = sc.nextInt();
				if(out>=min&&out<=max)
					break;
				else
					System.out.println("El rango admitido es "+rango);
				
			}catch (Exception e) {
				System.out.println("El valor introducido ha de ser numerico");
			}
		}while(true);
		
		return out;
	}
	
	//Solicita strings de manera recursiva
	private static String solicitarString(String pregunta) {
		String out;
		String outSinEspacios;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(pregunta);
			out = sc.nextLine();
			outSinEspacios = out;
			outSinEspacios.replace(" ", "");
		}while(!out.equals("")&&outSinEspacios.length()>0);
		
		return out;
	}

	//Solicita una nueva fecha a traves de la consola
 	private static Fecha solicitarFecha(String pregunta) {
		Fecha out = null;
		System.out.println(pregunta);
		do {
			try {
				int d = solicitarInt("Introduce el dia del mes", 1, 31);
				int m = solicitarInt("Introduce el mes", 1, 12);
				int a = solicitarInt("Introduce el anno", 1900, 3000);
				
				out = new Fecha(d, m ,a);
				break;
			}catch (Exception e) {
				System.out.println(e.getMessage()+", Introduce una fecha correcta:");
			}
			
		}while(true);		
		
		return out;
	}
	
 	//Solicita un nuevo familiar a traves de la consola
	private static Familiar solicitarFamiliar() {
		String dni = solicitarString("Introduce el DNI del Familiar:");
		String nombre = solicitarString("Introduce el nombre del Familiar:");
		Fecha fecha = solicitarFecha("Introduce la fecha de nacimiento del Familiar:");
		
		return new Familiar(dni, nombre, fecha);
	}
	
	//Genera un socio a traves de lo que el usuario mete por consola
	private static Socio solicitarSocio() {
		Socio out = null;
		do {
			String nombre = solicitarString("Introduce el nombre del Socio:");
			String tlf = solicitarString("Introduce el telefono del Socio:");
			String email = solicitarString("Introduce el email del Socio:");
			Fecha fNacimiento = solicitarFecha("Introduce la fecha de nacimiento del Socio:");
			
			try {
				out = new Socio(nombre, tlf, email, fNacimiento);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage()+", Vuelve a intentarlo:");
			}
		}while(true);
		
		return out;
	}

	//Busca un socio en el array de socios a traves de su id
	private static Socio seleccionarSocio() {
		Arrays.sort(socios);
		boolean correcto = false;
		Socio out = null;
		do {
			int idToSearch = solicitarInt("Introduce el numero de socio (0 para salir)", 0, socios[socios.length-1].getnSocio());
			
			if(idToSearch>0){
				int pos = Arrays.binarySearch(socios, new Socio(idToSearch));
				
				if(pos>=0) {
					out = socios[pos];
					correcto = true;
				}else
					System.out.println("Socio no encontrado, vuelve a intentarlo:");
			}else
				correcto = true;
			
			
		}while(!correcto);
		
		return out;
	}

	//Muestra los socios por pantalla a traves del criterio introducido
	private static void listarSocios(Comparator<Socio> c) {
			int i = 0;
			Arrays.sort(socios,c);
			for (Socio s:socios)
				//Si el socio está "eliminado no se muestra
				if(s.getnSocio()>0) {
					System.out.println(s);
					i++;
				}
			if(i<=0)System.out.println("No hay socios que mostrar");
	}

	//Agrega un socio al array de socios
	//Si existen socios "eliminados" los reemplaza
	private static void nuevoSocio(Socio s) {
		//Primero se ordena el array para que los socios eliminados esten primero
		Arrays.sort(socios);
		//Si hay algun socio eliminado se remplaza
		if(socios.length>0 && socios[0].getnSocio()<1)
			socios[0] = s;
		//De lo contrario crea un array con una posicion mas e introduce un socio en dicha posicion
		else {
			socios = Arrays.copyOf(socios, socios.length+1);
			socios[socios.length-1] = s;
		}
	}
	
	private static Object leerObjeto(String rutaArchivo) throws Exception{

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo));
		Object o = ois.readObject();
		return o;
	}
	
	private static void guardarObjeto(String rutaArchivo, Object o) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
		oos.writeObject(o);
		oos.close();
	}
	
}
