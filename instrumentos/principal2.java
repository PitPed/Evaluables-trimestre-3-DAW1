package instrumentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import instrumentos.Instrumento.Clase;

public class principal2 {
	
	public static void main(String[] args) {
		
		ArrayList<Instrumento> instrumentosAL = new ArrayList<>(
				Arrays.asList(new Instrumento[] {
						new Instrumento("Flauta", Clase.VIENTO),
						new Instrumento("Castannuelas", Clase.PERCUSION),
						new Instrumento("Arpa", Clase.CUERDA),
						new Instrumento(),
						new Instrumento("Kazoo", Clase.VIENTO),
						new Instrumento("Piano", Clase.CUERDA),
						new Instrumento("Melodica", Clase.VIENTO),
						new Instrumento("Bongos", Clase.PERCUSION),
						new Instrumento("Carraca", Clase.PERCUSION),
						new Instrumento("Flauta", Clase.VIENTO),
						new Instrumento("Castannuelas", Clase.PERCUSION),
						new Instrumento("Arpa", Clase.CUERDA),
						new Instrumento("Piano", Clase.PERCUSION)
					})
				);
		HashSet<Instrumento> instrumentosHS = new HashSet<>(instrumentosAL);
		TreeMap<Integer ,Instrumento> instrumentosTM = new TreeMap<>();
		
		
		Collections.sort(instrumentosAL);
		for (Instrumento ins: instrumentosAL) {
			System.out.println(ins);
			instrumentosTM.put(ins.getId(), ins);
		}
		
		System.out.println("\nTreeMap\n");
		
		for (Integer key: instrumentosTM.keySet()) {
			System.out.println(key + "\t" + instrumentosTM.get(key));
		}
		

		
		System.out.println("\nHashSet\n");
		
		for (Instrumento ins: instrumentosHS)
			System.out.println(ins);
		
		
		
	}
}