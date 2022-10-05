package tadCola;

import java.io.Serializable;

/**
 * @author Fausto Redrovan
 * @version 23/06/2022 *
 * @param <T> Tipo de dato del nodo
 */
public interface Cola<T> extends Serializable{
	boolean colaVacia();
	void eliminarCola();
	T primero() throws ColaVacia;
	void encolar(T x);
	T desencolar() throws ColaVacia;
	void quitarPrimero() throws ColaVacia;
	void mostrarEstadoCola();
	void imprimirCola();
    int numElemCola();
    void invertirCola() throws ColaVacia;
    String getNombre();
}
