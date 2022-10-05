package tadLista;

import java.io.Serializable;

public interface Lista<T> extends Serializable {
	void crearNodo ();
	  /*Crea un nuevo nodo en el tadLista*/
	T devolverClave ();
	  /*Devuelve la clave contenida en el nodo del tadLista*/
	NodoLista<T> devolverSiguiente ();
	  /*Devuelve una referencia al siguiente del tadLista*/
	NodoLista<T> devolverReferencia ();
		/*Devuelve una referencia al primer nodo del TadLista*/
	void asignarClave (T dato);
	  /*Asigna el dato al primer nodo del TadLista*/
	void asignarReferencia (NodoLista<T> referencia);
	  /*Hace que el primer nodo del TadLista apunte al mismo sitio que referencia*/
	void asignarReferenciaSiguiente (NodoLista<T> referenciaNueva);
	  /*Hace que el siguiente del nodo actual apunte ahora al mismo sitio que referenciaNueva*/
	void asignarNulo ();
	  /*Hace que el tadLista tome el valor null*/
	boolean esNulo ();
	  /*Devuelve true si el inicio del TadLista tiene valor null; false en caso contrario*/
	boolean esIgual (NodoLista<T> referencia);
	  /*Devuelve true si referencia apunta al mismo sitio que el tadLista, false en caso contrario*/
	void imprimirLista ();
	String getNombre();
}
