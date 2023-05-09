package liga;

import java.util.Comparator;

public class comparators {
	public static class ComparadorPuntosYGoles implements Comparator<IEquipo>{

		@Override
		public int compare(IEquipo e1, IEquipo e2) {
			int out = e2.getPuntos()-e1.getPuntos();
			if (out == 0) out = (e2.getGolesFavor()-e2.getGolesContra())-(e1.getGolesFavor()-e1.getGolesContra());
			return out;
		}
		
	}
}
