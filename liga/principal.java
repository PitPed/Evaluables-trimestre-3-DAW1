package liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class principal {
	public static ArrayList<IEquipo> equiposAL;
	public static TreeMap<String, IEquipo> equiposTM;
	public static int jornada = 0;
	
	public static void main(String[] args) {
		equiposTM = new TreeMap<>();
		equiposAL = new ArrayList<>();
		/*equiposAL = new ArrayList<>(
			Arrays.asList(new IEquipo[] {
				new Equipo("FC Titulcia"),
				new Equipo("FC Loeches"),
				new Equipo("FC Ajalvir"),
				new Equipo("FC Quijorna")
			}));*/
		
		IEquipo titulcia = new Equipo("FC Titulcia");
		IEquipo loeches = new Equipo("FC Loeches");
		
		equiposAL.add(titulcia);
		equiposAL.add(loeches);
		
		for(IEquipo equipo:equiposAL)
			equiposTM.put(equipo.getNombre(), equipo);
		
		
		//Jornada 1
		agregarPartido("FC Titulcia","FC Loeches",0,0);
		agregarPartido("FC Ajalvir","FC Quijorna",2,0);
		jornada++;
		clasificacion();
		//Jornada 2
		agregarPartido("FC Titulcia","FC Ajalvir",0,1);
		agregarPartido("FC Loeches","FC Quijorna",2,0);
		jornada++;
		clasificacion();
		//Jornada 3
		agregarPartido("FC Titulcia","FC Quijorna",2,1);
		agregarPartido("FC Loeches","FC Ajalvir",2,2);
		jornada++;
		clasificacion();
		//Jornada 4
		agregarPartido("FC Loeches","FC Titulcia",1,2);
		agregarPartido("FC Quijorna","FC Ajalvir",1,3);
		jornada++;
		clasificacion();
		//Jornada 5
		agregarPartido("FC Ajalvir","FC Titulcia",2,3);
		agregarPartido("FC Quijorna","FC Loeches",1,1);
		jornada++;
		clasificacion();
		//Jornada 6
		agregarPartido("FC Quijorna","FC Titulcia",0,3);
		agregarPartido("FC Ajalvir","FC Loeches",2,1);
		jornada++;
		clasificacion();
	}
	
	public static void agregarPartido(String local, String visitante, int golesLocal, int golesVisitante) {
		equiposTM.get(local).añadePartidoCasa(visitante, golesLocal, golesVisitante, jornada);
		equiposTM.get(visitante).añadePartidoFuera(local, golesVisitante, golesLocal, jornada);
	}
	
	public static void clasificacion() {
		Collections.sort(equiposAL,new comparators.ComparadorPuntosYGoles());
		System.out.println("\n\n============================================================\nJORNADA " + jornada );
		for (int i = 0;i<equiposAL.size();i++) {
			System.out.println("\n\nPosicion:\t"+(i+1));
			System.out.println(equiposAL.get(i));
		}
	}
}
