package instrumentos;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class comparators {
	public static class ComparatorTreeMap<V, K> implements Comparator<Map.Entry<String, Instrumento>>{

		@Override
		public int compare(Entry<String, Instrumento> o1, Entry<String, Instrumento> o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
		
	}
	public static void main(String[] args) {
		new ComparatorTreeMap<>();
	}
}
