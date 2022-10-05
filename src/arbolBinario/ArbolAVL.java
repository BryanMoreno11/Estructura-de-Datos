package arbolBinario;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

/**
 * �rbol AVL parametrizado para objetos comparables genericos tipo T
 * @author Fausto Redrovan 
 * @param <T> clase del objeto elemento del arbol
 */
public class ArbolAVL<T extends Comparable<T>> extends ArbolBB<T> {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de un �rbol AVL de nombre <em>nombre</em> y con un nodo raiz con el <em>dato</em>
	 * @param nombre Nombre del arbol AVL
	 * @param dato Para el nodo raiz
	 */
	public ArbolAVL(String nombre, T dato) {
		super(nombre, dato);
	}
	
	/**
	 * Constructor de un �rbol AVL con nombre y vacio (nulo)
	 * @param nombre Nombre del arbol nulo (vacio)
	 */
	public ArbolAVL(String nombre) {
		super(nombre);
	}
	
	/**
	 * Constructor de un arbol AVL sin nombre y con un nodo raiz con el <em>dato</em>
	 * @param raiz Nodo raiz
	 */
	public ArbolAVL(T dato) {
		super(null, dato);
	}

	/**
	 * Constructor de un �rbol AVL sin nombre y vac�o
	 */
	public ArbolAVL() {
		super();
	}

	/**
	 * Busca un objeto <em>dato</em> a partir de la raiz
	 * @param dato Objeto a buscar
	 * @return Nodo que contiene el objeto si lo encuentra, y <em>null</em> si no lo encuentra
	 */
	public NodoArbol<T> buscarNodo(T dato) {
		return buscarNodo(this.getRaiz(), dato);		
	}
	
	/**
	 * Busca un objeto <em>dato</em> a partir del subarbol <em>arbol</em>
	 * @param arbol Subarbol
	 * @param dato Objeto a buscar
	 * @return Nodo que contiene el objeto si lo encuentra, y <em>null</em> si no lo encuentra
	 */
	private NodoArbol<T> buscarNodo(NodoArbol<T> arbol, T dato) {
		if(arbol != null) {
			if(arbol.getClave().compareTo(dato) == 0)
				return arbol;
			else
				if(arbol.getClave().compareTo(dato) > 0 ) {
					return buscarNodo(arbol.getIz(), dato);
				}
				else {
					return buscarNodo(arbol.getDe(), dato);
				}	
		}
		else
			return arbol;		
	}
	
	/**
	 * Rotaci�n simple a la izquierda
	 * @param arbol Subarbol a rotar
	 * @return arbol rotado
	 */
	public NodoArbol<T> rotacionIzquierda(NodoArbol<T> arbol) {
		NodoArbol<T> aux  = arbol.getIz();	
		
		arbol.setIz(aux.getDe());	
		aux.setDe(arbol);
		arbol.setFe(altura(arbol.getDe()) - altura(arbol.getIz()));
		return aux;
	}
	
	/**
	 * Rotacion simple a la derecha
	 * @param arbol Subarbol a rotar
	 * @return �rbol rotado
	 */
	public NodoArbol<T> rotacionDerecha(NodoArbol<T> arbol) {
		NodoArbol<T> aux  = arbol.getDe();
		
		arbol.setDe(aux.getIz());	
		aux.setIz(arbol);
		arbol.setFe(altura(arbol.getDe()) - altura(arbol.getIz()));
		return aux;
	}
	
	/**
	 * Rotacion doble a la izquierda
	 * @param arbol Subarbol a rotar
	 * @return arbol rotado
	 */
	public NodoArbol<T> rotacionDobleIzquierda(NodoArbol<T> arbol) {
		NodoArbol<T> aux;		
		
		arbol.setIz(rotacionDerecha(arbol.getIz()));
		aux = rotacionIzquierda(arbol);
		return aux;
	}
	
	/**
	 * Rotacion doble a la derecha
	 * @param arbol Subarbol a rotar
	 * @return arbol rotado
	 */
	public NodoArbol<T> rotacionDobleDerecha(NodoArbol<T> arbol) {
		NodoArbol<T> aux;		
		
		arbol.setDe(rotacionIzquierda(arbol.getDe()));
		aux = rotacionDerecha(arbol);
		return aux;
	}
	
	/**
	 * Inserta un nuevo nodo en el arbol AVL a partir de un subarbol. 
	 * Si el objeto del nuevo nodo ya existe en el arbol, este no se inserta.
	 * Si el nuevo nodo produce un desbalanceo, se producen las rotaciones necesarias para balancear el arbol.
	 * Esto generara una variacion en el subarbol que se rota y por tanto el metodo entrega una nueva raiz de dicho subarbol.
	 * @param nuevo Nodo a insertar con un objeto nuevo
	 * @param arbol Ra�z del subarbol a partir del que se insertara el nodo
	 * @return La raiz del subarbol (rotado o no) donde se ingresara el nodo
	 */
	private NodoArbol<T> insertar(NodoArbol<T> nuevo, NodoArbol<T> arbol) {
		NodoArbol<T> nuevoPadre = arbol;
		
		if(nuevo.getClave().compareTo(arbol.getClave()) < 0 ) {
			if(arbol.getIz() == null) {
				arbol.setIz(nuevo);
			}
			else {
				arbol.setIz(insertar(nuevo, arbol.getIz()));
				if(altura(arbol.getDe()) - altura(arbol.getIz()) == -2){ //hay desbalanceo
					if(nuevo.getClave().compareTo(arbol.getIz().getClave()) < 0) {
						nuevoPadre = rotacionIzquierda(arbol);							
					}
					else {
						nuevoPadre = rotacionDobleIzquierda(arbol);
					}
						
				}
			}
		}
		else {
			if(nuevo.getClave().compareTo(arbol.getClave()) > 0) {
				if(arbol.getDe() == null) {
					arbol.setDe(nuevo);
				}
				else {
					arbol.setDe(insertar(nuevo, arbol.getDe()));
					if((altura(arbol.getDe()) - altura(arbol.getIz())) == 2){ //hay desbalanceo
						if(nuevo.getClave().compareTo(arbol.getDe().getClave()) > 0) {
							nuevoPadre = rotacionDerecha(arbol);							
						}
						else {
							nuevoPadre = rotacionDobleDerecha(arbol);
						}
							
					}
				}
			}
			else {
				System.out.println("Nodo duplicado");
			}
		}
		//Actualizando el FE
		nuevoPadre.setFe(altura(nuevoPadre.getDe()) - altura(nuevoPadre.getIz()));
		return nuevoPadre;		
	}
	
	/**
	 * Inserta un nuevo objeto en el arbol. Si el objeto ya existe no se inserta.
	 * @param dato Objeto a insertar
	 */
	public void insertar(T dato) {
		NodoArbol<T> nuevo = new NodoArbol<T>(dato);
		
		if(getRaiz() == null) {
			setRaiz(nuevo);
		}
		else {
			setRaiz(insertar(nuevo, getRaiz()));
		}
	}
	
	public void eliminar(T dato) {
		Eliminar e = new Eliminar();
		setRaiz(e.borrarNodo(getRaiz(), dato));
		if(!e.encontrado)
			System.out.println("Dato no encontrado");
	}
	
	class Eliminar{
		boolean encontrado = false;
		
		NodoArbol<T> borrarNodo(NodoArbol<T> arbol, T dato) {
			NodoArbol<T> p, aux;
			
			if(arbol != null) {
				if(arbol.getClave().compareTo(dato) == 0) {
					encontrado = true;
					p = arbol;
					if(arbol.getIz() == null)
						arbol = arbol.getDe();
					else
						if(arbol.getDe() == null)
							arbol = arbol.getIz();
						else 
							arbol.setIz(eliminar2Hijos(arbol.getIz(), p));	
				}
				else {
					if(arbol.getClave().compareTo(dato) > 0 ) {
						aux = borrarNodo(arbol.getIz(), dato);
						if(encontrado)
							arbol.setIz(aux);
					}
					else {
						aux = borrarNodo(arbol.getDe(), dato);
						if(encontrado)
							arbol.setDe(aux);
					}
				}
				if(arbol!=null && encontrado) {
					arbol.setFe(altura(arbol.getDe()) - altura(arbol.getIz()));
					if(arbol.getFe() == -2 || arbol.getFe() == 2) {
						arbol = balancear(arbol);
					}					
				}
				
			}			
			return arbol;
		}
		
		NodoArbol<T> eliminar2Hijos(NodoArbol<T> arbol, NodoArbol<T> p) {
			NodoArbol<T> resul;
			
			if(arbol.getDe() != null) {
				resul = arbol;
				arbol.setDe(eliminar2Hijos(arbol.getDe(), p));
			}
			else {
				p.setClave(arbol.getClave());
				resul = arbol.getIz();
			}	
			//parche
			if(resul != null) {
				resul.setFe(altura(resul.getDe()) - altura(resul.getIz()));
				if(resul.getFe() == -2 || resul.getFe() == 2) {
					resul = balancear(resul);
				}
			}
			return resul;
		}
		
		NodoArbol<T> balancear(NodoArbol<T> arbol) {
			if(arbol.getFe() == -2) 
				if(arbol.getIz().getFe() == 1)
					arbol = rotacionDobleIzquierda(arbol);
				else // es 0 o -1
					arbol = rotacionIzquierda(arbol);
			else //es 2
				if(arbol.getDe().getFe() == -1)
					arbol = rotacionDobleDerecha(arbol);
				else //es 0 o 1
					arbol = rotacionDerecha(arbol);
			arbol.setFe(altura(arbol.getDe()) - altura(arbol.getIz()));
			return arbol;
		}
	}
	
	@Override
	public void listarAmplitudNiveles() {
		try {
			listarAmplitudNiveles(this.getRaiz());
		} catch (ColaVacia e) {

		}
	}
	
	private void listarAmplitudNiveles(NodoArbol<T> arbol) throws ColaVacia {
		NodoArbol<T> p;
		Cola<NodoArbol<T>> cola = new TadCola<>();
		
		p = arbol;
		if(p != null)
			cola.encolar(p);
		while(!cola.colaVacia()) {
			p = cola.desencolar();
			System.out.println("clave:" + p.getClave() + " nivel:" + nivel(p.getClave()) + " fe:" + p.getFe());
			if(p.getIz() != null)
				cola.encolar(p.getIz());
			if(p.getDe() != null)
				cola.encolar(p.getDe());
		}
	}
	
}
