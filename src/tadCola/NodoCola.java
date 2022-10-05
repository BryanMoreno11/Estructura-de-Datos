package tadCola;

import java.io.Serializable;

/**
 * @author Fausto Redrovan
 * @version 23/06/2022 *
 * @param <T> Tipo de dato del nodo
 */
class NodoCola<T> implements Serializable
{
	private static final long serialVersionUID = 1L;
	// Atributos accesibles desde otras rutinas del paquete
	T dato;
	NodoCola<T> siguiente;
		
	// Constructores

	NodoCola(T elemento, NodoCola<T> n)
	{ 
		dato = elemento; 
		siguiente = n; 
	}
}
