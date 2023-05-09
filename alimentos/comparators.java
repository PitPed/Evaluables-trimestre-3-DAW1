package alimentos;

import java.util.Comparator;

public class comparators {
	public static class ComparatorTipo implements Comparator<Alimento>{

		@Override
		public int compare(Alimento o1, Alimento o2) {
			return o1.getTipo().compareTo(o2.getTipo());
		}
		
	}
}
