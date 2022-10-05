package algoritmos;

import tadLista.Lista;
import tadLista.TadLista;

public class AlgoritmosListas {
	
	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		lista.crearNodo();
		lista.asignarClave(dato);
	}
	
	public static <T> int contar(Lista<T> lista) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return contarR(aux);
	}
	
	private static <T> int contarR(Lista<T> aux) {
		if(!aux.esNulo()) {
			aux.asignarReferencia(aux.devolverSiguiente());
			return 1 + contarR(aux);			
		} else
			return 0;
	}
	
	public static <T> boolean eliminarPrimero(Lista<T> lista) {
		boolean resul = false;
		if(!lista.esNulo()) {
			lista.asignarReferencia(lista.devolverSiguiente());
			resul = true;
		}		
		return resul;
	}
	
	public static <T> void insertarAlFinal(Lista<T> lista, T dato) {
		Lista<T> aux;
		if(lista.esNulo())
			insertarAlPrincipio(lista, dato);
		else {
			aux = new TadLista<>();
			aux.asignarReferencia(lista.devolverReferencia());
			insertarAlFinalR(aux, dato);
		}
	}
	
	private static <T> void insertarAlFinalR(Lista<T> aux, T dato) {
		Lista<T> aux2;
		
		if(aux.devolverSiguiente() == null) {
			 aux2 = new TadLista<>();
			 insertarAlPrincipio(aux2, dato);
			 aux.asignarReferenciaSiguiente(aux2.devolverReferencia());			 
		} else {
			aux.asignarReferencia(aux.devolverSiguiente());
			insertarAlFinalR(aux, dato);
		}		
	}
	
	public static <T> void duplicarLista1(Lista<T> listaO, Lista<T> listaD) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(listaO.devolverReferencia());
		duplicarLista1R(aux, listaD);
	}
	
	private static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD) {
		if(!aux.esNulo()) {
			insertarAlFinal(listaD, aux.devolverClave());
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista1R(aux, listaD);
		}
	}
	
	public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(listaO.devolverReferencia());
		duplicarLista2R(aux, listaD);
	}
	
	private static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD) {
		T dato;
		if(!aux.esNulo()) {	
			dato = aux.devolverClave();
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista2R(aux, listaD);
			insertarAlPrincipio(listaD, dato);
		}
	}
	
	public static <T extends Comparable<T>> boolean buscar(Lista<T> lista, T dato) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return buscarR(aux, dato);
	}
	
	private static <T extends Comparable<T>> boolean buscarR(Lista<T> aux, T dato) {
		boolean resul = false;
		
		if(!aux.esNulo()) {
			if(aux.devolverClave().compareTo(dato) == 0) {
				resul = true;
			} else {
				aux.asignarReferencia(aux.devolverSiguiente());
				resul = buscarR(aux, dato);
			}		
		}
		return resul;
	}
	
	public static <T extends Comparable<T>> boolean insertar(Lista<T> lista, T dato, T datoPos) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return insertarR(aux, dato, datoPos);
	}
	
	private static <T extends Comparable<T>> boolean insertarR(Lista<T> aux, T dato, T datoPos) {
		boolean resul = false;
		Lista<T> aux1;		
		if(!aux.esNulo()) {
			if(aux.devolverClave().compareTo(datoPos) == 0) {
				aux1 = new TadLista<>();
				insertarAlPrincipio(aux1, dato);
				aux1.asignarReferenciaSiguiente(aux.devolverSiguiente());
				aux.asignarReferenciaSiguiente(aux1.devolverReferencia());
				resul = true;
			} else {
				aux.asignarReferencia(aux.devolverSiguiente());
				resul = insertarR(aux, dato, datoPos);
			}		
		}
		return resul;
	}
	
	public static <T extends Comparable<T>> boolean insertarPos(Lista<T> lista, T dato, int pos) {
		if(pos>=2 && pos<=contar(lista)+1) {
			Lista<T> aux = new TadLista<>();
			aux.asignarReferencia(lista.devolverReferencia());
			return insertarPos(aux, dato, pos, 1);
		}
		else
			if(pos==1) {
				insertarAlPrincipio(lista, dato);
				return true;
			}
			else
				return false;
	}
	
	private static <T extends Comparable<T>> boolean insertarPos(Lista<T> aux, T dato, int pos, int cont) {
		boolean resul = false;		
		if(!aux.esNulo()) {
			if(cont == pos-1) {
				resul = insertar(aux, dato, aux.devolverClave());
			} else {
				aux.asignarReferencia(aux.devolverSiguiente());
				resul = insertarPos(aux, dato, pos, cont+1);
			}		
		}
		return resul;
	}
	public static <T extends Comparable<T>> T menorElemento(Lista<T> lista) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(lista.devolverReferencia());
		return menorElementoR(aux, aux.devolverClave());
	}

	private static <T extends Comparable<T>> T menorElementoR(Lista<T> aux, T dato) {
		if (!aux.esNulo()) {
			if (aux.devolverClave().compareTo(dato) < 0) {
				dato = aux.devolverClave();
				aux.asignarReferencia(aux.devolverSiguiente());
				dato = menorElementoR(aux, dato);
			} else {
				aux.asignarReferencia(aux.devolverSiguiente());
				dato = menorElementoR(aux, dato);
			}
		}
		return dato;
	}
	public static <T extends Comparable<T>> T mayorElemento(Lista<T> lista) {
		Lista<T> aux = new TadLista<>();
		aux.asignarReferencia(lista.devolverReferencia());
		return mayorElementoR(aux, lista.devolverClave());
	}

	public static <T extends Comparable<T>> T mayorElementoR(Lista<T> aux, T mayor) {
		if (!aux.esNulo()) {
			if (aux.devolverClave().compareTo(mayor) > 0)
				mayor = aux.devolverClave();
			aux.asignarReferencia(aux.devolverSiguiente());
			mayor = mayorElementoR(aux, mayor);
		}
		return mayor;
	}
	public static <T extends Comparable<T>> void eliminar(Lista<T> lista, T dato) {
		T element;
		if(!lista.esNulo()) {
			if(lista.devolverClave().compareTo(dato)==0) {
				lista.asignarReferencia(lista.devolverSiguiente());
	
			}else {
				element=lista.devolverClave();
				lista.asignarReferencia(lista.devolverSiguiente());
				eliminar(lista, dato);
				insertarAlPrincipio(lista, element);
			}		
		}
		
	}
	public static<T extends Comparable<T>> void ordenarMayor(Lista<T> lista) {
		Lista<T> aux=new TadLista<T>();
		ordenarMayorR(lista, aux);
	}
	private static<T extends Comparable<T>> void ordenarMayorR(Lista<T> lista,Lista<T> aux) {
		if(!lista.esNulo()) {
			insertarAlPrincipio(aux, menorElemento(lista));
			eliminar(lista, menorElemento(lista));
			ordenarMayorR(lista, aux);
		}else {
			lista.asignarReferencia(aux.devolverReferencia());
		}
			
	}
	public static<T extends Comparable<T>> void ordenarMenor(Lista<T> lista) {
		Lista<T> aux=new TadLista<T>();
		ordenarMenorR(lista, aux);
	}
	private static<T extends Comparable<T>> void ordenarMenorR(Lista<T> lista,Lista<T> aux) {
		if(!lista.esNulo()) {
			insertarAlPrincipio(aux, mayorElemento(lista));
			eliminar(lista, mayorElemento(lista));
			ordenarMenorR(lista, aux);
		}else {
			lista.asignarReferencia(aux.devolverReferencia());
		}
			
	}
}
