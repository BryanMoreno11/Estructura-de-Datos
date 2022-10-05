package grafos;

import java.io.*;
import java.util.*;

public class GrafoMA implements Grafo {
	private String nombre;
	int maxNodos; // Tama�o m�ximo de la tabla.
	int numVertices; // N�mero de v�rtices.
	boolean matrizAdy[][]; // Matriz de adyacencias del grafo.
	boolean dirigido; // Indica si es dirigido o no.

	/**
	 * CONSTRUCTORES: public Grafo() --> constructor por defecto, construye un grafo
	 * vacio public Grafo (int n) --> construye una matriz de nxn con los valores a
	 * false. public Grafo (BufferedReader buffer) --> Constructor con
	 * BufferedReader (a m� no se me ha ocurrido). Primero le pide al usuario el
	 * n�mero de v�rtices del grafo (n). Luego crea una matriz de nxn. A
	 * continuaci�n, le pide n veces al usuario que introduzca una l�nea con n
	 * tokens, que ser�n los valores de las celdas de la matriz. StringTokenizer
	 * identifica los valores introducidos por el usuario.
	 **/

	public GrafoMA() {
		maxNodos = numVertices = 0;
	}

	public GrafoMA(boolean d) {
		maxNodos = numVertices = 0;
		dirigido = d;
	}

	public GrafoMA(int n, boolean d) { // construye una matriz de nxn sin arcos
		dirigido = d;
		maxNodos = n;
		numVertices = 0;
		matrizAdy = new boolean[n][n];
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++)
				matrizAdy[i][j] = false;
		}
	}

	public GrafoMA(BufferedReader buffer, boolean d) {

		try {
			dirigido = d;
			System.out.println("\nN�mero de nodos del grafo: ");
			String line = buffer.readLine();
			StringTokenizer token = new StringTokenizer(line);
			if (token.countTokens() != 1)
				throw new Error("\nError: introduzca un �nico valor.");
			int n = Integer.parseInt(token.nextToken());
			System.out.print("\nEl n�mero de v�rtices es " + n + "\n");
			if (n > 0)
				matrizAdy = new boolean[n][n];
			numVertices = maxNodos = n;
			for (int i = 0; i < n; i++) {
				int l = i + 1;
				System.out.print("\nIntroduzca los valores para la fila " + l + "\n");
				line = buffer.readLine();
				token = new StringTokenizer(line);
				if (token.countTokens() != n)
					throw new Error("\nError de formato en la matriz de adyacencias.");
				for (int j = 0; j < n; j++) {
					int entry = Integer.parseInt(token.nextToken());
					matrizAdy[i][j] = (entry != 0) ? true : false;
					// si no es dirigido, intento hacer la matriz sim�trica
					if (!dirigido) {
						matrizAdy[j][i] = matrizAdy[i][j];
					} // Achtung!!
				}
			}
		} catch (IOException x) {
			throw new Error("\nbad input stream!!");
		}
	} // fin de GrafoMA (BufferedReader buffer)

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

	// M�TODO COPIARGRAFO

	public GrafoMA CopiarGrafo(GrafoMA grafoOrigen) {
		GrafoMA g = new GrafoMA();
		int n = grafoOrigen.orden();
		if (n > 0) {
			g.matrizAdy = new boolean[n][n];
		}
		g.maxNodos = g.numVertices = n;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				g.matrizAdy[i][j] = grafoOrigen.matrizAdy[i][j];
			}
		return g;
	}

	// ------------------------------------

	// M�TODOS PARA INSERTAR Y ELIMINAR VERTICES

	// ------------------------------------

	/**
	 * insertaVertice(int n): se simplifica el m�todo de manera que no deja insertar
	 * v�rtices si se supera el l�mite de nodos del grafo maxNodos
	 *
	 */

	public void insertaVertice(int n) {
		if (n > maxNodos - numVertices)
			System.out.println("Error, se supera el n�mero de nodos m�ximo del grafo");
		else {
			for (int i = 0; i < numVertices + n; i++) {
				for (int j = numVertices; j < numVertices + n; j++) // simplemento a�ado el valor false a las celdas
					matrizAdy[i][j] = matrizAdy[j][i] = false;
			}
		}
		numVertices += n;
	}

	public void eliminarVertice(int v) {
		numVertices--;
		int i;
		for (i = 0; i < v; i++) {
			for (int j = v; j < numVertices; j++) {
				matrizAdy[i][j] = matrizAdy[i][j + 1];
			}
		}
		for (i = v; i < numVertices; i++) {
			int j;
			for (j = 0; j < v; j++) {
				matrizAdy[i][j] = matrizAdy[i + 1][j];
			}
			for (j = v; j < numVertices; j++) {
				matrizAdy[i][j] = matrizAdy[i + 1][j + 1];
			}
		}
	}

	// ------------------------------------

	// M�TODOS PARA INSERTAR Y ELIMINAR ARISTAS

	// ------------------------------------

	public void insertaArista(int i, int j) {
		if (i>= numVertices)
			System.out.println("Error, no existe el v�rtice en el grafo");
		else {
			matrizAdy[i][j] = true;
			if (!dirigido) {
				matrizAdy[j][i] = matrizAdy[i][j];
			}
		}
		
	}

	public void eliminaArista(int i, int j) {
		if (j >= numVertices)
			System.out.println("Error, no existe el v�rtice en el grafo");
		else {
			matrizAdy[i][j] = false;
			if (!dirigido) {
				matrizAdy[j][i] = false;
			}
		}
	

	}

	// --------------------------------

	// M�todos de acceso

	// --------------------------------

	public boolean esVacio(GrafoMA g) {
		return (numVertices == 0);
	}

	public boolean existeArista(int i, int j) {
		if ((i >= numVertices) || (j >= numVertices)) {
			System.out.println("Error, los vertices no se encuentran en el grafo.");
			return false;
		} else
			return matrizAdy[i][j];
	}

	public int gradoIn(int j) { //
		int gIn = 0;
		for (int i = 0; i < numVertices; i++) // recorro por filas manteniendo la posici�n de la columna fija en [j]
			if (matrizAdy[i][j]) {
				gIn++;
				if (this.esNoDirigido() && i == j)
					gIn++;
			}
		return gIn;
	}

	public int gradoOut(int i) {
		int gOut = 0;
		for (int j = 0; j < numVertices; j++) // recorro por columnas, manteniendo la posici�n de la fila fija en [i]
			if (matrizAdy[i][j]) {
				gOut++;
				if (this.esNoDirigido() && i == j)
					gOut++;
			}
		return gOut;
	}

	public int incidencia(int i) {
		if (!dirigido)
			return gradoIn(i);
		else
			return gradoIn(i) + gradoOut(i);
	}

	public int orden() {
		return numVertices;
	}

	public int tamanno() // N�mero de aristas (las aristas de un grafo no dirido se cuentan dos veces
	{
		int tm = 0;
		// boolean undirected = true;

		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++)
				if (matrizAdy[i][j])
					tm++;
		if (dirigido)
			return tm;
		else
			return tm / 2;
	}

	public boolean esNoDirigido() {
		boolean dir = true;
		for (int i = 0; i < numVertices; i++)
			for (int j = 0; j < numVertices; j++) {
				if (matrizAdy[i][j] != matrizAdy[j][i])
					dir = false;
			}
		return dir;
	}

	// --------------------------------
	// poner y obtener
	// --------------------------------

	public void ponerMaxNodos(int n) {
		this.maxNodos = n;
	}

	public int obtenerMaxNodos() {
		return this.maxNodos;
	}

	public void ponerDirigido(boolean d) {
		this.dirigido = d;
	}

	public boolean obtenerDirigido() {
		return this.dirigido;
	}

	public int obtenerNumVertices() {
		return this.numVertices;
	}

	// --------------------------------
	// m�todo que imprime la tabla de adyacencias
	// --------------------------------

	public void imprimirGrafo() {
		System.out.println("Tama�o m�ximo del grafo: " + tamanno() + "\n");
		System.out.println("La matriz contiene " + numVertices + " v�rtices: \n");
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (matrizAdy[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	};

}// end class
