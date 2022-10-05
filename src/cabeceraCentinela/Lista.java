package cabeceraCentinela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Lista implements Serializable{
	private static final long serialVersionUID = 1L;
	public NodoLista cab, cent;
	public Lista () {
		cab = new NodoLista (0);
		cent = new NodoLista (0);
		cab.sig = cent;
	}
	public boolean busqueda (int dato) {
		NodoLista anterior, actual;
		boolean resul = false;
	 
		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave < dato) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual != cent) && (actual.clave == dato))
			resul = true;
		return resul;
	}
	public void insertar (int dato) {
		NodoLista anterior, actual, aux;

		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave < dato) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual.clave > dato) || (actual == cent)) {
			aux = new NodoLista (dato);
			aux.sig = actual;
			anterior.sig = aux;
		}
		else System.out.println ("Error, el elemento esta repetido");
	}
	public void eliminar (int dato) {
		NodoLista anterior, actual;

		anterior = cab;
		actual = anterior.sig;
		cent.clave = dato;
		while (actual.clave < dato) {
			anterior = actual;
			actual = actual.sig;
		}
		if ((actual == cent) || (actual.clave > dato))
			System.out.println ("Error, elemento inexistente");
		else anterior.sig = actual.sig;
	}
	public void imprimirLista () {
	 	NodoLista actual;

		actual = cab.sig;
		while (actual != cent) {
			System.out.print (actual.clave + " ");
			actual = actual.sig;
		}
		System.out.println (" FIN");
	}
	public void cargarLista () throws NumberFormatException, IOException {
		int cantidad, i, x;
		BufferedReader linea_entrada = new BufferedReader(new InputStreamReader(System.in));
		        
		System.out.println ("Numero de elementos de la lista: ");
		cantidad = Integer.parseInt(linea_entrada.readLine());
		for (i = 0; i < cantidad; i++) {
		    x = Integer.parseInt(linea_entrada.readLine());
		    insertar(x);
		}
	}
}
