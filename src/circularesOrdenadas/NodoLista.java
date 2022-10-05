package circularesOrdenadas;

import java.io.Serializable;

public class NodoLista<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	T clave;
	NodoLista<T> sig;
	NodoLista(T x)	{
	    clave=x;
	    sig=null;
	}
}

