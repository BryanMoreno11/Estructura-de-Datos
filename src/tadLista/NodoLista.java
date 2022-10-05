package tadLista;

import java.io.Serializable;

public class NodoLista<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	T clave;
	NodoLista<T> sig;
	NodoLista (T x, NodoLista<T> n) {
		clave = x;
		sig = n;
	}
}

