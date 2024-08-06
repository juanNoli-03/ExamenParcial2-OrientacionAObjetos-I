package modelos;

//IMPORTAMOS LIBRERIAS DE LOCALDATE, LOCALTIME Y PERIOD
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Funciones {
	
	public static double convertirADouble (int n) {
		return (double) n;
	}
	
	public static boolean esBisiesto (LocalDate fecha) {
		
		return fecha.getYear() % 4 == 0 && (fecha.getYear() % 100 == 0 && fecha.getYear() % 400 == 0);
	}
	
	public static boolean esFechaValida (LocalDate fecha) throws Exception {
		
		boolean condicion = false;
		
		if ((fecha.getMonthValue() >= 1 && fecha.getMonthValue() <= 12) && (fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 31)) {
		
		if ((fecha.getMonthValue() == 1 || fecha.getMonthValue() == 3 || fecha.getMonthValue() == 5 || fecha.getMonthValue() == 7 || fecha.getMonthValue() == 8 
				|| fecha.getMonthValue() == 10 || fecha.getMonthValue() == 12)) {
			
			condicion = fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 31;
		}
		
		if (fecha.getMonthValue() == 4 || fecha.getMonthValue() == 6 || fecha.getMonthValue() == 9 || fecha.getMonthValue() == 11) {
			
			condicion = fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 30;
		}
		
		if (fecha.getMonthValue() == 1) {
			
			if (esBisiesto (fecha)) {
				
				condicion = fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 29;
			
			} else {
				
				condicion = fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 28; 
			}
		}
		
		} else {
			
			throw new Exception ("\nError! La fecha ingresada no es valida.\n");
		}
		
		return condicion;
	}
	
	public static String traerFechaCorta (LocalDate fecha) {
		
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear(); 
	}
	
	public static String traerFechaLarga (LocalDate fecha) {
		
		return fecha.getDayOfWeek() + " " + fecha.getDayOfMonth() + " of " + fecha.getMonth() + " of " + fecha.getYear();
	}
	
	public static String traerHoraCorta (LocalTime hora) {
		
		String formato = "";
		
		if (hora.getHour() >= 00 && hora.getHour() <= 12) {
			
			formato = "a.m.";
		
		} else {
			
			formato = "p.m.";
		}
		
		return hora.getHour() + ":" + hora.getMinute() + " " + formato; 
	}
	
	public static boolean esDiaHabil (LocalDate fecha) {
		
		return (fecha.getDayOfWeek().getValue() >= 1 && fecha.getDayOfWeek().getValue() <= 5);
	}
	
	public static int traerDiaDeLaSemana(LocalDate fecha) {
		
		return fecha.getDayOfWeek().getValue();
	}
	
	public static String traerMesEnLetras(LocalDate fecha) {
		
		return fecha.getMonth().name();
	}
	
	public static int traerCantDiasEnUnMes (int anio, int mes) {
		
		LocalDate fecha = LocalDate.of(anio, mes, 1);
		
		return fecha.lengthOfMonth();
	}
	
	public static double aproximar2Decimal (double valor) {
		
		return (double) Math.round(valor * 100) / 100;
	}
	
	public static boolean esNumero (char c) {
		
		return Character.isDigit(c);
	}
	
	public static boolean esLetra (char c) {
		
		return Character.isLetter(c);
	}
	
	public static boolean esCadenaNros (String cadena) {
		
		int coincidencias = 0;
		
		for (int i = 0; i < cadena.length(); i ++) {
			
			if (Character.isDigit(cadena.charAt(i))) {
				
				coincidencias ++;
			}
		}
		
		return coincidencias == cadena.length();
	}
	
	public static boolean esCadenaLetras(String cadena) {
		
		int coincidencias = 0;
		
		for (int i = 0; i < cadena.length(); i ++) {
			
			if (Character.isLetter(cadena.charAt(i)) || cadena.charAt(i) == ' ') {
				
				coincidencias ++;
			}
		}
		
		return coincidencias == cadena.length();
	}
	
	public static boolean fechaEntre (LocalDate fecha, LocalDate desde, LocalDate hasta) {
		
		boolean condicion = false;
		
		if ((fecha.isAfter(desde) && fecha.isBefore(hasta)) || (fecha.equals(desde) || fecha.equals(hasta))) {
			
			condicion = true;
		}
		
		return condicion;
	}
	
	public static boolean horaEntre (LocalTime hora, LocalTime desde, LocalTime hasta) {
		
		boolean condicion = false;
		
		if ((hora.isAfter(desde) && hora.isBefore(hasta)) || (hora.equals(desde) || hora.equals(hasta))) {
			
			condicion = true;
		}
		
		return condicion;
	}
	
	public static void cambiarLetra (char letra) {
		
		StringBuilder palabra = new StringBuilder ("Fede Noceti");
		
		System.out.println(palabra);
		
		palabra.setCharAt(0, letra);
		
		System.out.println(palabra);
				
	}
	
	public static int cantidadDiasEnUnPeriodo (LocalDate fechaInicio, LocalDate fechaFinal) {
		
		return Period.between(fechaInicio, fechaFinal).getDays();
	}
	
	public static int cantidadDeAniosEntre (LocalDate fechaInicio, LocalDate fechaFinal) {
		
		return Period.between(fechaInicio, fechaFinal).getYears();
	}
	
	public static LocalDate traerPrimerDiaHabilMesSiguiente (LocalDate fecha) {
		
		LocalDate nuevaFecha = LocalDate.of(fecha.getYear(), fecha.getMonthValue() + 1, 1);
		
		int i = 1;
		
		while (i < fecha.lengthOfMonth()) {
			
			nuevaFecha = LocalDate.of(fecha.getYear(), fecha.getMonthValue() + 1, i);
			
			if (esDiaHabil (fecha)) {
				
				i = i + fecha.lengthOfMonth();
			}
			
			i ++;
		}
		
		return nuevaFecha;
	}
}
