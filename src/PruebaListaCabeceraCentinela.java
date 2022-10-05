

import cabeceraCentinela.Lista;
import cabeceraCentinela.NodoLista;

public class PruebaListaCabeceraCentinela {
		static Lista copiarLista (Lista origen) {
			NodoLista aux;
			Lista resul = new Lista ();
			
			aux = origen.cab.sig;
			while (aux != origen.cent) {
		 	  resul.insertar(aux.clave);
		 	  aux = aux.sig;
			}  
			return resul;
		}
		static void escribirLista (Lista lista) {
			NodoLista aux;
			
			aux = lista.cab.sig;
			while (aux != null) {
					System.out.print(aux.clave+" ");
					aux = aux.sig;
			}
			System.out.println (" FIN");
		}
		public static void main(String[] args) {
			Lista lista1 = new Lista ();
			
			lista1.insertar (1);
			lista1.insertar (5);
			lista1.insertar (4);
			lista1.eliminar(4);
			lista1.insertar (4);
			lista1.insertar (7);
			lista1.insertar (6);
			System.out.println ("probemos el metodo escribirLista:");
			escribirLista(lista1);
			lista1.insertar (9);
			lista1.eliminar (7);
			System.out.println ("probemos el metodo copiarLista:");
			Lista copia= copiarLista (lista1);
			copia.imprimirLista ();
			copia.insertar(7);
			lista1.imprimirLista ();
			System.out.println ("Copia de lista1 despues de insertar 7: ");
			copia.imprimirLista ();
			lista1.imprimirLista();
		}
	}
