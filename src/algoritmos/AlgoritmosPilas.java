package algoritmos;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class AlgoritmosPilas {
	
	/**
	 * Cuenta recursivamente los elementos de una pila
	 * @param <T>
	 * @param pila
	 * @return
	 * @throws PilaVacia
	 */
	public static <T> int contarPila(Pila<T> pila) throws PilaVacia {
		int resul;
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			resul = 1 + contarPila(pila);
			pila.apilar(elem);
		}		
		else
			resul = 0;
		return resul;
	}
	
	/**
	 * Envia el dato al fondo de la pila. La pila no se altera.
	 * @param <T>
	 * @param pila
	 * @param dato
	 * @throws PilaVacia
	 */
	public static <T> void sumergir(Pila<T> pila, T dato) throws PilaVacia {
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			sumergir(pila, dato);
			pila.apilar(elem);
		}
		else
			pila.apilar(dato);
	}
	
	/**
	 * Imprime en pantalla la pila invertida
	 * @param <T>
	 * @param pila
	 * @throws PilaVacia
	 */
	public static <T> void imprimirInvertida(Pila<T> pila) throws PilaVacia {
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			imprimirInvertida(pila);
			System.out.print(elem + " ");
			pila.apilar(elem);
		}
	}
	
	/**
	 * Devuelve el dato que esta en el fondo de la pila. La pila no se altera
	 * @param <T>
	 * @param pila
	 * @return
	 * @throws PilaVacia
	 */
	public static <T> T fondo(Pila<T> pila) throws PilaVacia {
		T elem, resul = null;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			if(pila.pilaVacia())
				resul = elem;
			else
				resul = fondo(pila);
			pila.apilar(elem);
		}
		return resul;			
	}
	
	/**
	 * Invierte la pila
	 * @param <T>
	 * @param pila
	 * @throws PilaVacia
	 */
	public static <T> void invertirPila(Pila<T> pila) throws PilaVacia {
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			invertirPila(pila);
			sumergir(pila, elem);
		}
	}
	
	/**
	 * Busca el dato en la pila. La pila no se altera.
	 * @param <T>
	 * @param pila
	 * @param dato
	 * @return true si el dato existe en la pila, false si no se encuentra
	 * @throws PilaVacia
	 */
	public static <T extends Comparable<T>> boolean buscar(Pila<T> pila, T dato) throws PilaVacia {
		boolean resul;
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			if(elem.compareTo(dato) == 0)
				resul = true;
			else
				resul = buscar(pila, dato);
			pila.apilar(elem);
		}
		else
			resul = false;
		return resul;
	}
	
	/**
	 * Devuelve al dato mayor de una pila de elementos comparables. La pila no se altera.
	 * @param <T>
	 * @param pila
	 * @return
	 */
	public static <T extends Comparable<T>> T mayor(Pila<T> pila) {
		T resul;
		try {
			resul = mayor(pila, pila.cima());
		} catch (PilaVacia e) {
			resul = null;
		}
		return resul;
	}
	
	private static <T extends Comparable<T>> T mayor(Pila<T> pila, T mayor) throws PilaVacia {
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			if(elem.compareTo(mayor) > 0) {
				mayor = elem;
			}
			mayor = mayor(pila, mayor);
			pila.apilar(elem);
		}
		return mayor;
	}
	
	/**
	 * Devuelve al dato menor de una pila de elementos comparables. La pila no se altera.
	 * @param <T>
	 * @param pila
	 * @return
	 */
	public static <T extends Comparable<T>> T menor(Pila<T> pila) {
		T resul;
		try {
			resul = menor(pila, pila.cima());
		} catch (PilaVacia e) {
			resul = null;
		}
		return resul;
	}
	
	private static <T extends Comparable<T>> T menor(Pila<T> pila, T menor) throws PilaVacia {
		T elem;
		if(!pila.pilaVacia()) {
			elem = pila.desapilar();
			if(elem.compareTo(menor) < 0) {
				menor = elem;
			}
			menor = menor(pila, menor);
			pila.apilar(elem);
		}
		return menor;
	}
	
	/**
	 * Obtiene una copia de una pila. La pila original no se altera.
	 * @param <T>
	 * @param pilaO Pila original
	 * @param pilaD Copia de la pila original
	 * @throws PilaVacia
	 */
	public static <T> void copiarPila(Pila<T> pilaO, Pila<T> pilaD) throws PilaVacia {
		T elem;
		if(!pilaO.pilaVacia()) {
			elem = pilaO.desapilar();
			copiarPila(pilaO, pilaD);
			pilaO.apilar(elem);
			pilaD.apilar(elem);
		}
	}
	
	/**
	 * Apila el dato en orden ascendente en una pila de elementos comparables.
	 * @param <T>
	 * @param pila
	 * @param dato
	 * @throws PilaVacia
	 */
	public static <T extends Comparable<T>> void apilarEnOrden(Pila<T> pila, T dato) throws PilaVacia {
		T elem = dato;
		if(!pila.pilaVacia()) {
			if(dato.compareTo(pila.cima()) > 0) {
				elem = pila.desapilar();
				apilarEnOrden(pila, dato);
			}
		}
		pila.apilar(elem);
		
	}
	
	/**
	 * Convierte la informaci�n de una pila en un String
	 * @param <T> Tipo de dato de los elementos de la pila
	 * @param pila Pila con los elementos
	 * @return El estado de la pila como String
	 */
	public static <T> String pilaToString(Pila<T> pila) {
		StringBuffer cadena = new StringBuffer("Estado de la pila " + pila.getNombre() +": ");
		try {
			cadena = pilaToString(pila, cadena);
		} catch (PilaVacia e) {

		}
		return cadena.toString();
	}
	
	private static <T> StringBuffer pilaToString(Pila<T> pila, StringBuffer cadena) throws PilaVacia {
        T elem;
        if(!pila.pilaVacia()) {
        	elem = pila.desapilar();
            cadena.append(elem + " ");
            cadena = pilaToString(pila, cadena);
            pila.apilar(elem);
        }
        return cadena;
    }
	
	/**
	 * Devuelve el elemento del fondo de la pila
	 * @param <T>
	 * @param pila
	 * @return el dato que hasta al fono de la pila
	 * @throws PilaVacia
	 */
	public static<T> T elementoFondo(Pila<T> pila) throws PilaVacia {
		T aux=null, element;
		if(pila.numElemPila()>1) {
			element=pila.desapilar();
			aux=elementoFondo(pila);
			pila.apilar(element);
		}
		if(pila.numElemPila()==1) {
			aux=pila.cima();
		}
		return aux;
	}
	
	/**
	 * Este metodo elimina de la pila el dato que se le pase como parámetro
	 * @param <T>
	 * @param pila
	 * @param dato
	 * @return devuelve true si se logra eliminar el dato de la pila y false en el caso contrario
	 * @throws PilaVacia
	 */
	public static <T extends Comparable<T>> boolean  eliminar(Pila<T> pila,T dato) throws PilaVacia{
		return eliminarR(pila, dato, false);
	}
	private static <T extends Comparable<T>> boolean  eliminarR(Pila<T> pila,T dato, boolean encontrar) throws PilaVacia{
		T element;
		if(!pila.pilaVacia()&& encontrar==false) {
			element=pila.desapilar();
			if(element.compareTo(dato)==0) {
				encontrar=true;
			}else
				encontrar=eliminarR(pila, dato,encontrar);
			if(element!=dato) 
				pila.apilar(element);

		}
		return encontrar;
	}
	/**
	 * Ordena los datos de la pila de menor a mayor
	 * @param <T>
	 * @param pila
	 * @throws PilaVacia
	 */
	public static <T extends Comparable<T>> void ordenarMenorPila(Pila<T> pila) throws PilaVacia {
		Pila<T> aux = new TadPila<T>();
		ordenarMenorPilaR(pila, aux);
	}

	private static <T extends Comparable<T>> void ordenarMenorPilaR(Pila<T> pila, Pila<T> aux) throws PilaVacia {
		if (!pila.pilaVacia()) {
			aux.apilar(menor(pila));
			eliminar(pila, menor(pila));
			ordenarMenorPilaR(pila, aux);
			pila.apilar(aux.desapilar());
		}

	}
	
	/**
	 * Ordena los datos de la pila de Mayor a menor
	 * @param <T>
	 * @param pila
	 * @param aux
	 * @throws PilaVacia
	 */
	public static <T extends Comparable<T>> void ordenarMayorPila(Pila<T> pila) throws PilaVacia {
		Pila<T> aux = new TadPila<T>();
		ordenarMayorPilaR(pila, aux);
	}

	private static <T extends Comparable<T>> void ordenarMayorPilaR(Pila<T> pila, Pila<T> aux) throws PilaVacia {
		if (!pila.pilaVacia()) {
			aux.apilar(mayor(pila));
			eliminar(pila, mayor(pila));
			ordenarMayorPilaR(pila, aux);
			pila.apilar(aux.desapilar());
		}

	}

}
