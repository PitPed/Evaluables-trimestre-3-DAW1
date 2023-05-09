package club;

import java.io.Serializable;
import java.time.LocalDate;

public class Fecha implements Comparable<Fecha>, Serializable{
	static Fecha fechaActual = new Fecha();
	private int dia, mes, anno;
	
	
	/**
	 * <i>MESES</i> es un array en el que estan guardados los nombres de los meses
	 */
	public final static String[] MESES = {
			"Enero",
			"Febrero",
			"Marzo",
			"Abril",
			"Mayo",
			"Junio",
			"Julio",
			"Agosto",
			"Septiembre",
			"Octubre",
			"Noviembre",
			"Diciembre"};
	
	/**
	 * <i>DIAS</i> guarda el numero de dias que tiene cada mes, no se tienen en cuenta los anos bisiestos
	 */
	public final int[] DIAS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	Fecha(){
		LocalDate f = java.time.LocalDate.now();
		this.dia = f.getDayOfMonth();
		this.mes = f.getMonthValue();
		this.anno = f.getYear();
		
	}
	
	Fecha(int d, int m, int a) throws Exception{
		
		anno = a;
		if (m<1||m>12) {
			throw(new Exception("Mes no valido"));
		}else mes = m;
		
		if ((d>0&&d<=DIAS[mes-1])||(d==29&&mes==2&&anno%4==0))
			dia = d;
		else	
			throw(new Exception("Dia no valido"));
		
		if(this.compareTo(fechaActual)>0)
			throw(new Exception("La fecha debe ser menor a la actual"));
		
	}
	
	public int sumarDiasMeses(int mes) {
		int dias = 0;
		for(int i=mes;i>0;i--)
			dias += DIAS[i-1];
		return dias;
	}
	
	//Devuelve cuantos dias han pasado desde el anno 0, mes 0, dia 0
	private int totalDias() {
		return anno*365+(anno%4)+sumarDiasMeses(mes)+dia;
	}

	@Override
	public int compareTo(Fecha other) {
		return this.totalDias()-other.totalDias();
	}
	
	
	public String toStringBonito() {
		return dia+" de "+MESES[mes-1]+" del "+anno;
	}
	@Override
	public String toString() {
		return (dia>9?dia:"0"+dia)+"-"+(mes>9?mes:"0"+mes)+"-"+anno;
	}
	
}
