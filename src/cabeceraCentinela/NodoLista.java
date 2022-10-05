package cabeceraCentinela;

import java.io.Serializable;

public class NodoLista implements Serializable{
	private static final long serialVersionUID = 1L;
	public int clave;
	public NodoLista sig;
	public NodoLista (int dato) {
		clave = dato;
		sig = null;
	}
}

