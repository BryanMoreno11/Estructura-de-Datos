	package algoritmos;

import grafos.Grafo;
import grafos.GrafoLA;
import grafos.GrafoMA;
import grafos.Recorridos;

/**
 * Algoritmos de utilidad para grafos
 * @author Fausto Redrovan
 * @version 17/08/2022
 *
 */
public class AlgoritmosGrafos {
	
	/**
	 * Muestra informaci�n importante del grafo dado:
	 * Nombre
	 * Si es dirigido
	 * Grados de entrada y salida de los vertices
	 * Orden
	 * Tamaño
	 * Recorridos en profundidad y amplitud
	 * @param grafo Grafo (iplementado por matriz o lista de adyacencia)
	 */
	public static void estadoGrafo(Grafo grafo) {
		System.out.println("Estado del grafo " + grafo.getNombre());
		System.out.println("Grafo es Dirigido? " + (grafo.esNoDirigido()?"NO":"SI"));
		System.out.println("Grados de entrada y salida:");
		for(int i=0; i<grafo.obtenerNumVertices(); ++i)
			System.out.println("V�rtice " + i + ": GIn= " + grafo.gradoIn(i) + 
												" - GOut= " + grafo.gradoOut(i) +
												" - Incidencia= " + grafo.incidencia(i));
		System.out.println("Orden del grafo: " + grafo.orden());
		System.out.println("Tamaño del grafo: " + grafo.tamanno());
		grafo.imprimirGrafo();
		System.out.println("Recorrido en profundidad:");
		Recorridos.profundidad(grafo);
		System.out.println("Recorrido en amplitud:");
		Recorridos.amplitud(grafo);
	}
	
	/**
	 * Algoritmo de Warshall para determinar la matriz de caminos de un grafo
	 * Puede estar implementado con matriz o listas de adyacencia
	 * @param g Grafo cuya matriz de caminos se desea determinar.
	 * @return La matriz de caminos expresada como una matriz de enteros: 1 existe camino, 0 no existe camino
	 */
	public static int[][] matrizCaminos(Grafo g) {
		int n = g.obtenerNumVertices();
		int[][] P = new int[n][n]; // matriz de caminos
		// Se obtiene la matriz inicial: matriz de adyacencia
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				P[i][j] = g.existeArista(i, j) ? 1 : 0;
		// se obtienen, virtualmente, a partir de P0, las sucesivas
		// matrices P1, P2, P3 ,..., Pn-1, Pn que es la matriz de caminos
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					P[i][j] = Math.min(P[i][j] + P[i][k] * P[k][j], 1);
		return P;
	}
	
	/**
	 * Genera un grafo implementado como Matriz de Adyacencias o como Listas de Adyacencias, a partir de una matriz entera de adyacencias
	 * @param mAdy Matriz de adyacencias de un grafo como matriz de enteros: 1 existe arco, 0 no existe arco. Esta matriz debe ser cuadrada.
	 * @param ma Tipo de implementacion deseada: true genera un grafo con Matriz de Adyacencias, con false genera un grafo con Listas de Adyacencias
	 * @return El grafo generado a partir de la matriz de adyacencias
	 */
	public static Grafo getGrafo(int[][] mAdy, boolean ma){
		Grafo grafo;
		int n = mAdy.length;
		if(ma) //crea un grafo segun el tipo, se indica que es dirigido, pero es la disposici�n de los arcos es lo que lo define.
			grafo = new GrafoMA(n, true); 
		else
			grafo = new GrafoLA(n, true);
		grafo.insertaVertice(n);
		for(int i=0; i<mAdy.length; ++i)
			for(int j=0; j<mAdy[i].length; ++j)
				if(mAdy[i][j] == 1)
					grafo.insertaArista(i, j);				
		return grafo;
	}
		
	/**
	 * Metodo que retorna la multiplicaci�n de dos matrices de enteros C=AB
	 * Las matriz A es mxn y la matriz B es nxp, la matriz resultante es mxp
	 * @param a Matriz A de enteros
	 * @param b Matriz B de enteros
	 * @return La matriz resultante de multiplicar AxB o null si las matrices no son compatibles
	 */
	public static int[][] aXb(int[][] a, int[][] b) { 
		int m, n, p;
		int[][] c = null;
		
		if(a != null && b != null)
			if (a.length > 0 && b.length > 0) {
				m = a.length;
				n = a[0].length;
				p = b[0].length;

				if (n == b.length) {
					c = new int[m][p];
					for (int i = 0; i < m; i++)
						for (int j = 0; j < p; j++)
							for (int k = 0; k < n; k++)
								c[i][j] += a[i][k] * b[k][j];
				}
			}
		return c;
	}
	
	/**
	 * Imprime en forma tabular una matriz de enteros
	 * @param matriz Matriz de enteros
	 */
	public static void imprimirMatriz(int[][] matriz) {
		for(int[] i : matriz){
    		for(int j : i) {
    			System.out.print(j + "\t");
    		}
    		System.out.print("\n");
    	}
	}

	/**
	 * Genera la matriz de adyacencias de un grafo
	 * @param g Grafo. Puede estar implementado con matriz o listas de adyacencias.
	 * @return Matriz de adyacencias del grafo tipo entera: 1 existe arista, 0 no existe arista.
	 */
	public static int[][] matrizAdy(Grafo g){
		int n = g.obtenerNumVertices();
		int[][] ma = null;
		
		if(n!=0) {
			ma = new int[n][n];		
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					ma[i][j] = g.existeArista(i, j) ? 1 : 0;
				}
			}
		}
		return ma;
	}
	
	/**
	 * M�todo para determinar el numero de caminos de una longitud dada entre dos vertices
	 * @param g Grafo
	 * @param m Longitud de los caminos
	 * @param i V�rtice origen
	 * @param j V�rtice destino
	 * @return N�mero de caminos de longitud m desde i y hasta j, o -1 si el grafo no esta implementado
	 */
	public static int caminos(Grafo g, int m, int i, int j) {
		int resul = -1;	
		int[][] a = matrizAdy(g);
		int[][] mc = aXb(a, a); //m=2;
		
		if(m>2) {
			for(int k=3; k<=m; ++k) {
				mc = aXb(a, mc);
			}
		}
		if(mc != null) {
			resul = mc[i][j];
		}

		return resul;
	}
	
	/**
	 * M�todo recursivo para determinar el n�mero de caminos de una longitud dada entre dos vertices
	 * @param g Grafo
	 * @param m Longitud de los caminos
	 * @param i V�rtice origen
	 * @param j V�rtice destino
	 * @return N�mero de caminos de longitud m desde i y hasta j, o -1 si el grafo no esta implementado
	 */
	public static int caminosR(Grafo g, int m, int i, int j) {
		int resul = -1;	
		int[][] mc = matrizCaminosM(g, m);
		if(mc != null) {
			resul = mc[i][j];
		}
		return resul;
	}
	
	/**
	 * M�todo que retorna la matriz de caminos de longitud m de un Grafo dado
	 * @param g Grafo
	 * @param m Longitud de los caminos
	 * @return Matriz con el n�mero de caminos de longitud m para cada par de vertices
	 */
	public static int[][] matrizCaminosM(Grafo g, int m){
		return matrizCaminosM(matrizAdy(g), m);
	}
	
	/**
	 * M�todo que retorna la matriz de caminos de longitud m 
	 * a partir de la matriz de adyacencias de un grafo
	 * @param mAdy Matriz de adyacencia del grafo
	 * @param m Longitud de los caminos
	 * @return Matriz con el numero de caminos de longitud m para cada par de vertices
	 */
	public static int[][] matrizCaminosM(int[][] mAdy, int m){
		int[][] mc = mAdy;
		if(m>=2)
			mc = aXb(mAdy, matrizCaminosM(mAdy, m-1));		
		return mc;
	}
	
	/**
	 * Genera el grafo por cierre transitivo de un grafo dado, implementado como Matriz de Adyacencias o como Listas de Adyacencias
	 * @param grafo Grafo del cual se desea obtener el cierre transitivo. Puede estar implementado como matriz o lista de adyacencias
	 * @param ma Tipo de implementacion deseada: true genera un grafo con Matriz de Adyacencias, con false genera un grafo con Listas de Adyacencias
	 * @return El grafo de cierre transitivo generado a partir del grafo dado.
	 */
	public static Grafo getCTGrafo(Grafo grafo, boolean ma){
		 //Matriz de caminos del grafo
		 int[][] MC = AlgoritmosGrafos.matrizCaminos(grafo);
		 return AlgoritmosGrafos.getGrafo(MC, ma);
	}
	
	/**
	 * M�todo que determina si el Grafo grafo dirigido tiene ciclos
	 * @param grafo Grafo dirigido implementado por Listas o Matriz de adyacencias
	 * @return true si el grafo tiene ciclos o false si no tiene ciclos o no es dirigido
	 */
	public static boolean tieneCiclos(Grafo grafo) {
		boolean resul = false;
		int[][] mc;
		
		if(!grafo.esNoDirigido()) { //solo entra si el grafo es dirigido
			mc = AlgoritmosGrafos.matrizCaminos(grafo);
			for(int i=0; i<mc.length; ++i)
				if(mc[i][i]!=0) {
					resul = true;
					i = mc.length;
				}
		}
		return resul;
	}
	
	/**
	 * Determina el numero de bucles que tiene el Grafo grafo
	 * @param grafo Grafo cualquiera implementado por Listas o Matriz de adyacencias
	 * @return El numero de bucles del grafo
	 */
	public static int bucles(Grafo grafo) {
		int cont = 0;
		int[][] ma = AlgoritmosGrafos.matrizAdy(grafo);
		for(int i=0; i<ma.length; ++i)
			if(ma[i][i]==1)
				cont++;		
		return cont;
	}
	
	/**
	 * Genera la matriz transpuesta de una matriz dada
	 * @param matriz Matriz dada que puede ser regular o irregular
	 * @return La matriz transpuesta
	 */
	public static int[][] matrizT(int[][] matriz) {
		int numFilas = matriz.length; //numero de filas de la matriz
		int numCols;
		int[][] mT = new int[numFilas][];

		for (int fila = 0; fila < numFilas; ++fila) {
			numCols = matriz[fila].length; //numero de columnas por fila, no necesariamente es regular
			mT[fila] = new int[numCols]; //vector para las columnas de cada fila
			for (int col = 0; col < numCols; ++col)
				mT[fila][col] = matriz[col][fila];
		}
		return mT;
	}
	
	/**
	 * Genera el grafo inverso de un grafo dirigido dado
	 * @param grafo Grafo dirigido dado que puede ser por listas o matriz de adyacencia
	 * @param ma true si el grafo que se quiere obtener es por matriz de adyacencia, false si se quiere uno por listas de adyacencias
	 * @return El grafo inverso como Grafo o null si no es dirigido. Quien use el m�todo deber� hacer una casting hacia GrafoMA o GrafoLA
	 */
	public static Grafo getGrafoInverso(Grafo grafo, boolean ma){
		 //Matriz de caminos del grafo
		 int[][] MA = matrizAdy(grafo);	 
		 
		 return grafo.esNoDirigido()?null:getGrafo(matrizT(MA), ma);
	}
	
	/**
	 * Genera el grafo inverso de un grafo dirigido dado
	 * @param grafo Grafo dirigido dado por matriz de adyacencia
	 * @return El grafo inverso como Grafo o null si no es dirigido.
	 */
	public static Grafo getGrafoInverso(Grafo grafo) {
		Grafo aux;
		int n;
		if(!grafo.esNoDirigido()) {
			n = grafo.obtenerNumVertices();
			if(getTipoGrafo(grafo))
				aux = new GrafoMA(n, true);
			else
				aux = new GrafoLA(n, true);
			aux.insertaVertice(n);
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j)
					if(grafo.existeArista(i, j))
						aux.insertaArista(j, i);
			return aux;			
		} else
			return null;
	}
	
	/**
	 * Obtiene el tipo de implementacion del grafo dado
	 * @param grafo Grafo implementado por Matriz o Lista de adyacencias
	 * @return true si es por matriz de adyacencias, false si es por lista de adyacencias
	 */
	public static boolean getTipoGrafo(Grafo grafo) {
		boolean ma;
		if(grafo.getClass().getSimpleName().compareTo("GrafoMA")==0)
			ma = true;
		else
			ma = false;
		return ma;
	}
}
