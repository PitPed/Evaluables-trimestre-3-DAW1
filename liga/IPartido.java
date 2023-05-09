package liga;

public interface IPartido {
	public String getLocal();
	public String getVisitante();
	public int getGolesLocal();
	public int getGolesVisitante();
	public int getJornada();
	public String toString();
}

class Partido implements IPartido, Comparable<IPartido>{
	
	private String local,visitante;
	private int golesLocal, golesVisitante, jornada;
	
	public Partido(String local, String visitante, int golesLocal, int golesVisitante, int jornada) {
		this.local = local;
		this.visitante = visitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.jornada = jornada;
	}

	@Override
	public String getLocal() {
		return local;
	}

	@Override
	public String getVisitante() {
		return visitante;
	}

	@Override
	public int getGolesLocal() {
		return golesLocal;
	}

	@Override
	public int getGolesVisitante() {
		return golesVisitante;
	}

	@Override
	public int getJornada() {
		return jornada;
	}
	
	
	
	@Override
	public String toString() {
		return "Jornada "+jornada+"\t"+local+"\t"+golesLocal+" : "+golesVisitante+"\t"+visitante;
	}


	@Override
	public int compareTo(IPartido other) {
		return this.getJornada()-other.getJornada();
	}
}
