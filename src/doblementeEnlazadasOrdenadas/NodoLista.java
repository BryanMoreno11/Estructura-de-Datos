package doblementeEnlazadasOrdenadas;

import java.io.Serializable;

public class NodoLista<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	T clave;
	NodoLista<T> sig, ant;
	NodoLista (T x)	{
		clave = x;
		sig = null;
		ant = null;
	}
}

