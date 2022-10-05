package algoritmos;

public class Busqueda {
	public static <T extends Comparable<T>> int buscarBinaria(T dato, T[] vector) {
		int centro, inf=0, sup=vector.length-1;
		while(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro].compareTo(dato) == 0)
				return centro;
			else
				if(vector[centro].compareTo(dato) > 0)
					sup = centro - 1;
				else
					inf = centro + 1;
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int buscarBinariaR(T dato, T[] vector) {
		return buscarBinariaR(dato, vector, 0, vector.length-1);
	}
		
	private static <T extends Comparable<T>> int buscarBinariaR(T dato, T[] vector, int inf, int sup) {
		int centro;
		int resul = -1;
		if(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro].compareTo(dato) == 0)
				return centro;
			else {
				if(vector[centro].compareTo(dato) > 0)
					sup = centro - 1;
				else
					inf = centro + 1;
				resul = buscarBinariaR(dato, vector, inf, sup);
			}
		}
		return resul;
	}
	
	public static <T extends Comparable<T>> int buscarSecuencial(T dato, T[] vector) {
		int pos = 0, resul = -1;
		while(pos<=vector.length-1) {
			if(vector[pos].compareTo(dato) == 0) {
				resul = pos;
				pos = vector.length;
			}
			++pos;
		}
		return resul;
	}	
	
	public static <T extends Comparable<T>> int buscarSecuencialR(T dato, T[] vector) {
		return buscarSecuencialR(dato, vector, 0);
	}
	
	private static <T extends Comparable<T>> int buscarSecuencialR(T dato, T[] vector, int pos) {
		int resul = -1;
		if(pos<=vector.length-1) {
			if(vector[pos].compareTo(dato) == 0)
				resul = pos;
			else
				resul = buscarSecuencialR(dato, vector, pos+1);
		}
		return resul;
	}
}
