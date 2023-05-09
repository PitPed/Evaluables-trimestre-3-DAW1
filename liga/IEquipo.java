package liga;

import java.util.SortedSet;
import java.util.TreeSet;

public interface IEquipo {
	public String getNombre();
	public int getPuntos();
	public int getPartidosJugados();
	public int getGolesFavor();
	public int getGolesContra();
	public SortedSet<IPartido> getPartidosFuera();
	public SortedSet<IPartido> getPartidosCasa();
	public String toString();
	public int compareTo(Object o);
	public void añadePartidoCasa(String adversario, int gFavor, int gContra, int jornada);
	public void añadePartidoFuera(String adversario, int gFavor, int gContra, int jornada);
	public void recalculaValores();
}

class Equipo implements IEquipo{
	private String nombre;
	private int puntos, partidosJugados, golesFavor, golesContra;
	private SortedSet<IPartido> partidosFuera, partidosCasa;
	
	Equipo(String nombre){
		this.nombre = nombre;
		this.puntos = 0;
		this.partidosJugados = 0;
		this.golesFavor = 0;
		this.golesContra = 0;
		this.partidosFuera = new TreeSet<>();
		this.partidosCasa = new TreeSet<>();
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public int getPuntos() {
		return this.puntos;
	}

	@Override
	public int getPartidosJugados() {
		return this.partidosJugados;
	}

	@Override
	public int getGolesFavor() {
		return this.golesFavor;
	}

	@Override
	public int getGolesContra() {
		return this.golesContra;
	}

	@Override
	public SortedSet<IPartido> getPartidosFuera() {
		return this.partidosFuera;
	}

	@Override
	public SortedSet<IPartido> getPartidosCasa() {
		return this.partidosCasa;
	}

	@Override
	public int compareTo(Object o) {
		IEquipo other = (IEquipo) o;
		int out = this.getPuntos()-other.getPuntos();
		if (out == 0) out = (this.getGolesFavor()-this.golesContra)-(other.getGolesFavor()-other.getGolesContra());
		return out;
	}

	@Override
	public void añadePartidoCasa(String adversario, int gFavor, int gContra, int jornada) {
		partidosCasa.add(new Partido(this.getNombre(), adversario,gFavor,gContra,jornada));
		recalculaValores();
	}

	@Override
	public void añadePartidoFuera(String adversario, int gFavor, int gContra, int jornada) {
		partidosFuera.add(new Partido(this.getNombre(), adversario,gFavor,gContra,jornada));
		recalculaValores();
	}

	@Override
	public void recalculaValores() {
		this.puntos = 0;
		this.partidosJugados = 0;
		this.golesFavor = 0;
		this.golesContra = 0;
		
		int pCasa = partidosCasa.size();
		
		for(int i = 0; i<pCasa+partidosFuera.size();i++) {
			IPartido partido = null; 
			boolean local = i<pCasa;
			//partido =  local? partidosCasa.first():
			
			partidosJugados++;
			golesFavor +=partido.getGolesLocal();
			golesContra +=partido.getGolesVisitante();
			if(partido.getGolesLocal()>partido.getGolesVisitante())
				puntos+=3;
			else if(partido.getGolesLocal()==partido.getGolesVisitante())
				puntos+=1;
		}
		
		/*for(IPartido partido : partidosCasa) {
			partidosJugados++;
			golesFavor +=partido.getGolesLocal();
			golesContra +=partido.getGolesVisitante();
			if(partido.getGolesLocal()>partido.getGolesVisitante())
				puntos+=3;
			else if(partido.getGolesLocal()==partido.getGolesVisitante())
				puntos+=1;
		}
		
		for(IPartido partido : partidosFuera) {
			partidosJugados++;
			golesFavor +=partido.getGolesLocal();
			golesContra +=partido.getGolesVisitante();
			if(partido.getGolesLocal()>partido.getGolesVisitante())
				puntos+=3;
			else if(partido.getGolesLocal()==partido.getGolesVisitante())
				puntos+=1;
		}*/
	}
	
	@Override
	public String toString() {
		return "____________________________________________________________"+
				"\nEquipo:\t\t\t"+this.nombre+
				"\nPuntos:\t\t\t"+this.puntos+
				"\nPartidos Jugados:\t"+this.partidosJugados+
				"\nGoles a Favor:\t\t"+this.golesFavor+
				"\nGoles en Contra:\t"+this.golesContra;
	}
}
