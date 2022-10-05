package grafos;

import listaCalificadaOrdenada.Lista;
import listaCalificadaOrdenada.NodoLista;

public class GrafoLA implements Grafo {
	private String nombre;
	int maxNodos; // Tama�o m�ximo de la tabla.
	int numVertices; // N�mero de v�rtices.
	Lista<Integer>[] listaAdy; // Vector de Lista de adyacencias del grafo.
	boolean dirigido; // Indica si es dirigido o no.

//  ----------------------------------------
//	    CONSTRUCTORES Y M�TODOS DE ACCESO
//  ----------------------------------------

	public GrafoLA(boolean d) { // Grafo vac�o
		maxNodos = numVertices = 0;
		dirigido = d;
	}

	@SuppressWarnings("unchecked")
	public GrafoLA(int n, boolean d) { // construye una array de listas de tama�o n con 0 v�rtices.
		dirigido = d;
		maxNodos = n;
		numVertices = 0;
		listaAdy = (Lista<Integer>[]) new Lista[n];
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int obtenerNumVertices() {
		return this.numVertices;
	}

//  --------------------
//    ARISTAS
//  --------------------

	public void insertaArista(int i, int j) {
		if (i >= numVertices)
			System.out.println("Error, no existe el v�rtice en el grafo");
		else {
			listaAdy[i].insertar(j);
			if (!dirigido)
				listaAdy[j].insertar(i);
		}
	}

	public void eliminaArista(int i, int j) {
		if (j >= numVertices)
			System.out.println("Error, no existe el v�rtice en el grafo");
		else {
			listaAdy[i].eliminar(j);
			if (!dirigido) {
				listaAdy[j].eliminar(i);
			}
		}
	}

	public boolean existeArista(int i, int j) {
		if ((i >= numVertices) || (j >= numVertices)) {
			System.out.println("Error, los vertices no se encuentran en el grafo.");
			return false;
		} else
			return listaAdy[i].busqueda(j);
	}

//  --------------------
//  INSERTAR VERTICES
//  --------------------

	public void insertaVertice(int n) {// n: numero de vertices que quiero a�adir al grafo
		if (n > maxNodos - numVertices)
			System.out.println("Error, se supera el n�mero de nodos m�ximo del grafo");
		else {
			for (int i = 0; i < numVertices + n; i++) {
				if (listaAdy[i] == null)
					listaAdy[i] = new Lista<>("lista " + i);
			}
		}
		numVertices += n;
	}

//  --------------------
//  ELIMINAR VERTICES
//  --------------------

	public void eliminarVertice(int v) {
		int i;
		for (i = 0; i < numVertices; ++i) {
			if (listaAdy[i].busqueda(v))
				listaAdy[i].eliminar(v);
			for (int j = v; j < numVertices; ++j)
				if (listaAdy[i].busqueda(j + 1)) {
					listaAdy[i].eliminar(j + 1);
					listaAdy[i].insertar(j);
				}

		}
		for (i = v; i < numVertices - 1; ++i) {
			listaAdy[i] = listaAdy[i + 1];
		}
		listaAdy[numVertices - 1] = null;
		numVertices--;
	}

//  ----------------------------------------
//  GRADO IN, OUT E INCIDENCIA
//  ----------------------------------------

	public int gradoIn(int v) { // contar las veces que aparece i en las listas
		int gIn = 0;
		for (int i = 0; i < numVertices; i++)
			if (listaAdy[i].busqueda(v))
				gIn++;
		return gIn;
	}

	public int gradoOut(int i) { // contar los elementos de la lista
		int gOut = 0;
		NodoLista<Integer> aux = listaAdy[i].getInicio();
		while (aux != null) {
			gOut++;
			aux = aux.getSig();
		}
		return gOut;
	}

	public int incidencia(int i) {
		if (!dirigido)
			return gradoIn(i);
		else
			return gradoIn(i) + gradoOut(i);
	}

//  ----------------------------------------
//  ORDEN Y TAMA�O DEL GRAFO
//  ----------------------------------------

	public int orden() {
		return numVertices;
	}

	public int tamanno() { // N�mero de arcos, se cuenta el n�mero de nodos de las listas.
		int tm = 0;
		for (int i = 0; i < numVertices; i++) {
			tm += numElementos(listaAdy[i]);
		}
		if (!dirigido)
			tm = tm / 2;
		return tm;
	}

	static int numElementos(Lista<Integer> lista) {
		NodoLista<Integer> aux = lista.getInicio();
		int resul = 0;
		while (aux != null) {
			resul++;
			aux = aux.getSig();
		}
		return resul;
	}

// ----------------------------------------
// COMPRUEBA SI ES ""NO"" DIRIGIDO
// ----------------------------------------

	public boolean esNoDirigido() {
		boolean dir = true;

		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++) {
				if (listaAdy[i].busqueda(j) != listaAdy[j].busqueda(i))
					dir = false;
			}
		return dir;
	}

// ----------------------------------------
// IMPRIME LAS LISTAS DE ADYACENCIAS
// ----------------------------------------

	public void imprimirGrafo() {
		System.out.println("Tama�o m�ximo del grafo: " + tamanno() + "\n");
		System.out.println("El grafo contiene " + numVertices + " v�rtices: \n");
		for (int i = 0; i < numVertices; i++) {
			System.out.print("v�rtice " + i + ": ");
			escribir(listaAdy[i]);
		}
	}

	static void escribir(Lista<Integer> lista) {
		NodoLista<Integer> aux;
		aux = lista.getInicio();
		while (aux != null) {
			System.out.print(aux.getClave() + ", ");
			aux = aux.getSig();
		}
		System.out.println("FIN");
	}	
} 

