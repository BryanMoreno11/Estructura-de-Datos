package algoritmos;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class AlgoritmosColas {
	/**
	 * Cuenta recursivamente los elementos de una cola
	 * @param <T>
	 * @param cola
	 * @return
	 */
	public static <T> int contarCola(Cola<T> cola) {
		int resul;
		try {
			resul = contarColaR(cola);
			cola.invertirCola();
			
		} catch (ColaVacia e) {
			resul = -1;
		}
		return resul;
	}
	
	private static <T> int contarColaR(Cola<T> cola) throws ColaVacia {
		int resul;
		T elem;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			resul = 1 + contarColaR(cola);			
			cola.encolar(elem);
		}
		else 
			resul = 0;
		return resul;
	}
	
	/**
	 * Busca el dato en la cola de elementos comparables.
	 * La cola no se altera.
	 * @param <T>
	 * @param cola
	 * @param dato
	 * @return true si encuentra el dato, false si no lo encuentra
	 */
	public static <T extends Comparable<T>> boolean buscar(Cola<T> cola, T dato) {
		boolean resul;
		try {
			resul = buscarR(cola, dato);
			cola.invertirCola();
		} catch (ColaVacia e) {
			resul = false;
		}
		return resul;
	}
	
	private static <T extends Comparable<T>> boolean buscarR(Cola<T> cola, T dato) throws ColaVacia {
		T elem;
		boolean resul = false;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			if(elem.compareTo(dato) == 0) {
				resul = true;
				cola.invertirCola();
			}
			else
				resul = buscarR(cola, dato);
			cola.encolar(elem);
		}
		return resul;
	}
	
	/**
	 * Devuelve al dato mayor de una cola de elementos comparables. 
	 * La cola no se altera.
	 * @param <T>
	 * @param cola
	 * @return
	 */
	public static <T extends Comparable<T>> T mayor(Cola<T> cola) {
		T resul;
		try {
			resul = mayor(cola, cola.primero());
			cola.invertirCola();
		} catch (ColaVacia e) {
			resul = null;
		}
		return resul;
	}
	
	private static <T extends Comparable<T>> T mayor(Cola<T> cola, T mayor) throws ColaVacia {
		T elem;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			if(elem.compareTo(mayor) > 0) {
				mayor = elem;
			}
			mayor = mayor(cola, mayor);
			cola.encolar(elem);
		}
		return mayor;
	}
	
	/**
	 * Devuelve al dato menor de una cola de elementos comparables. 
	 * La cola no se altera.
	 * @param <T>
	 * @param cola
	 * @return
	 */
	public static <T extends Comparable<T>> T menor(Cola<T> cola) {
		T resul;
		try {
			resul = menor(cola, cola.primero());
			cola.invertirCola();
		} catch (ColaVacia e) {
			resul = null;
		}
		return resul;
	}
	
	private static <T extends Comparable<T>> T menor(Cola<T> cola, T menor) throws ColaVacia {
		T elem;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			if(elem.compareTo(menor) < 0) {
				menor = elem;
			}
			menor = menor(cola, menor);
			cola.encolar(elem);
		}
		return menor;
	}
	
	/**
	 * Devuelve el elemento que es el �ltimo de la cola.
	 * La cola no se altera.
	 * @param <T>
	 * @param cola
	 * @return
	 */
	public static <T> T ultimo(Cola<T> cola) {
		T resul;
		
		try {
			resul = ultimoR(cola);
			cola.invertirCola();
		} catch (ColaVacia e) {
			resul = null;
		}		
		return resul;
	}
	
	private static <T> T ultimoR(Cola<T> cola) throws ColaVacia {
		T elem, resul = null;
		if(!cola.colaVacia()) {
			elem = cola.desencolar();
			if(cola.colaVacia())
				resul = elem;
			else
				resul = ultimoR(cola);
		}
		return resul;
	}
	
	/**
	 * Obtiene una copia de una cola. 
	 * La cola original no se altera.
	 * @param <T>
	 * @param colaO Cola original
	 * @param colaD Copia de la cola original
	 * @throws ColaVacia
	 */
	public static <T> void copiarCola(Cola<T> colaO, Cola<T> colaD) throws ColaVacia {
		copiarColaR(colaO, colaD);
		colaO.invertirCola();
	}
	
	private static <T> void copiarColaR(Cola<T> colaO, Cola<T> colaD) throws ColaVacia {
		T elem;
		if(!colaO.colaVacia()) {
			elem = colaO.desencolar();
			colaD.encolar(elem);
			copiarColaR(colaO, colaD);
			colaO.encolar(elem);
		}
	}
	
	/**
	 * Convierte la informaci�n de una pila en un String
	 * @param <T> Tipo de dato de los elementos de la pila
	 * @param cola Pila con los elementos
	 * @return El estado de la pila como String
	 */
	public static <T> String colaToString(Cola<T> cola) {
		StringBuffer cadena = new StringBuffer("Estado de la cola " + cola.getNombre() + ": ");
		try {
			cadena = colaToString(cola, cadena);
			cola.invertirCola();
		} catch (ColaVacia e) {

		}
		return cadena.toString();
	}
	
	private static <T> StringBuffer colaToString(Cola<T> cola, StringBuffer cadena) throws ColaVacia {
        T elem;
        if(!cola.colaVacia()) {
        	elem = cola.desencolar();
            cadena.append(elem + " ");
            cadena = colaToString(cola, cadena);
            cola.encolar(elem);
        }
        return cadena;
    }
	/**
	 * Este método elimina de la cola el dato que se pasa como parámetro siempre y cuando dicho dato
	 * este presente en la cola
	 * @param <T>
	 * @param cola
	 * @param dato
	 * @return Retorna true si se elimina el dato de la cola, caso contrario devuelve un false
	 * @throws ColaVacia
	 */
	public static <T extends Comparable<T>> boolean eliminarElemento(Cola<T> cola, T dato) throws ColaVacia {
		boolean a = eliminarElementoR(cola, dato, false);
		cola.invertirCola();
		return a;
	}

	private static <T extends Comparable<T>> boolean eliminarElementoR(Cola<T> cola, T dato, boolean encontrar)
			throws ColaVacia {
		T element;
		if (!cola.colaVacia() && encontrar == false) {
			element = cola.desencolar();
			if (element.compareTo(dato) == 0) {
				encontrar = true;
				cola.invertirCola();
			}

			else
				encontrar = eliminarElementoR(cola, dato, encontrar);
			if (element != dato)
				cola.encolar(element);
		}
		return encontrar;
	}
	/**
	 * Ordena los datos de la cola de menor a mayor
	 * @param <T>
	 * @param cola
	 * @throws ColaVacia
	 */
	public static <T extends Comparable<T>> void ordenarMenorCola(Cola<T> cola) throws ColaVacia{
		Cola<T> aux= new TadCola<T>();
		ordenarMenorColaR(cola, aux);
		cola.invertirCola();
	}
		
		private static <T extends Comparable<T>> void ordenarMenorColaR(Cola<T> cola, Cola<T> aux) throws ColaVacia{
			if(!cola.colaVacia()) {
				aux.encolar(mayor(cola));
				eliminarElemento(cola, mayor(cola));
				ordenarMenorColaR(cola, aux);
				cola.encolar(aux.desencolar());
			}else
				cola=aux;
		}
		/**
		 * Ordena los datos de la cola de mayor a menor
		 * @param <T>
		 * @param cola
		 * @throws ColaVacia
		 */
		public static <T extends Comparable<T>> void ordenarMayorCola(Cola<T> cola) throws ColaVacia{
			Cola<T> aux= new TadCola<T>();
			ordenarMayorColaR(cola, aux);
			cola.invertirCola();
		}
			
			private static <T extends Comparable<T>> void ordenarMayorColaR(Cola<T> cola, Cola<T> aux) throws ColaVacia{
				if(!cola.colaVacia()) {
					aux.encolar(menor(cola));
					eliminarElemento(cola, menor(cola));
					ordenarMayorColaR(cola, aux);
					cola.encolar(aux.desencolar());
				}else
					cola=aux;
			}
}
