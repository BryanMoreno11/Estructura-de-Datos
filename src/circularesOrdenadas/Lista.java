package circularesOrdenadas;

import java.io.Serializable;

public class Lista<T extends Comparable<T>> implements Serializable{
	private static final long serialVersionUID = 1L;
	private NodoLista<T> ultimo;
	private String nombre;

	public Lista(String nombreLista) {
		ultimo = null;
		nombre = nombreLista;
	}

	public Lista() {
		ultimo = null;
		nombre = null;
	}
	
	public NodoLista<T> getUltimo() {
		return ultimo;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void imprimirLista() {
		NodoLista<T> aux;

		if (ultimo != null) {
			aux = ultimo.sig;
			System.out.print(nombre + ": ");
			while (aux != ultimo) {
				System.out.print(aux.clave.toString() + " ");
				aux = aux.sig;
			}
			System.out.print(aux.clave + " ");
		}
		System.out.println("FIN");
	}

	public void insertar(T dato) {
		NodoLista<T> aux, actual, anterior;

		if (ultimo == null) {
			aux = new NodoLista<T>(dato);
			ultimo = aux;
			ultimo.sig = ultimo;
		} else {
			anterior = ultimo;
			actual = ultimo.sig;
			while ((actual.clave.compareTo(dato) < 0) && (actual != ultimo)) {
				anterior = actual;
				actual = actual.sig;
			}
			if (actual.clave.compareTo(dato) != 0) {
				aux = new NodoLista<T>(dato);
				if ((actual != ultimo) || (actual.clave.compareTo(dato) > 0)) {
					aux.sig = actual;
					anterior.sig = aux;
				} else if (actual.clave.compareTo(dato) < 0) {
					aux.sig = actual.sig;
					actual.sig = aux;
					ultimo = aux;
				}
			} else
				System.out.println("error, el elemento ya existe");
		}
	}

	public void eliminar(T x) {
		NodoLista<T> ant, act;

		if (ultimo != null) {
			ant = ultimo;
			act = ultimo.sig;
			while (act != ultimo && act.clave.compareTo(x) < 0) {
				ant = act;
				act = act.sig;
			}
			if (act.clave.compareTo(x) == 0) {
				ant.sig = act.sig;
				if (ultimo == act)
					if (ultimo != ant)
						ultimo = ant;
					else
						ultimo = null;
			} else
				System.out.println("No existe el nodo de clave " + x);
		} else
			System.out.println("La lista esta vacia ");
	}

	public boolean busqueda(T x) {
		boolean resul = false;
		NodoLista<T> aux;

		if (ultimo != null) {
			if (ultimo.clave.compareTo(x) == 0)
				resul = true;
			else {
				aux = ultimo.sig;
				while (aux.clave.compareTo(x) <= 0 && aux != ultimo) {
					if (aux.clave.compareTo(x) == 0)
						resul = true;
					aux = aux.sig; // por ser lista ordenada
				}
			}
		}
		return resul;
	}

	public boolean busquedaR(T x) {
		return busquedaR(ultimo.sig, x);
	}

	public boolean busquedaR(NodoLista<T> nodo, T x) {
		boolean resul = false;
		if (nodo != null) {
			if (nodo.clave.compareTo(x) == 0)
				resul = true;
			else if (nodo.clave.compareTo(x) < 0)
				resul = busquedaR(nodo.sig, x);
		}
		return resul;
	}
}

