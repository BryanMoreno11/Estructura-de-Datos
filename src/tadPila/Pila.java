package tadPila;

import java.io.Serializable;

/**
 * @author Fausto Redrovan
 * @version 23/06/2022
 *
 */
public interface Pila<T> extends Serializable {
	boolean pilaVacia();
	void eliminarPila();
	T cima() throws PilaVacia;
	void apilar(T x);
	T desapilar() throws PilaVacia;
	void decapitar() throws PilaVacia;
	void imprimirPila();
	int numElemPila();
	String getNombre();
}

