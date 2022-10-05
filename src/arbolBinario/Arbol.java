package arbolBinario;

import java.io.Serializable;

import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Arbol<T extends Comparable<T>> implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private NodoArbol<T> raiz;
	
	
	public Arbol() {
		this.setNombre(null);
		this.setRaiz(null);
	}

	public Arbol(String nombre, T clave) {
		this.setNombre(nombre);
		this.setRaiz(new NodoArbol<>(clave));
	}
	
	public Arbol(T clave) {
		this.setNombre(null);
		this.setRaiz(new NodoArbol<>(clave));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	public void preOrder() {
		preOrder(this.getRaiz());
	}
	
	private void preOrder(NodoArbol<T> arbol) {
		if(arbol!=null) {
			System.out.print(arbol.getClave() + " ");
			preOrder(arbol.getIz());
			preOrder(arbol.getDe());
		}
	}
	
	public void inOrder() {
		inOrder(this.getRaiz());
	}
	
	private void inOrder(NodoArbol<T> arbol) {
		if(arbol!=null) {			
			inOrder(arbol.getIz());
			System.out.print(arbol.getClave() + " ");
			inOrder(arbol.getDe());
		}
	}
	
	public void postOrder() {
		postOrder(this.getRaiz());
	}
	
	private void postOrder(NodoArbol<T> arbol) {
		if(arbol!=null) {			
			postOrder(arbol.getIz());			
			postOrder(arbol.getDe());
			System.out.print(arbol.getClave() + " ");
		}
	}
	
	public void listarAmplitud() {
		try {
			listarAmplitud(this.getRaiz());
		} catch (ColaVacia e) {

		}
	}
	
	private void listarAmplitud(NodoArbol<T> arbol) throws ColaVacia {
		NodoArbol<T> p;
		Cola<NodoArbol<T>> cola = new TadCola<>();
		
		p = arbol;
		if(p != null)
			cola.encolar(p);
		while(!cola.colaVacia()) {
			p = cola.desencolar();
			System.out.print(p.getClave() + " ");
			if(p.getIz() != null)
				cola.encolar(p.getIz());
			if(p.getDe() != null)
				cola.encolar(p.getDe());
		}
	}
	
	public final static <T extends Comparable<T>> void juntar(Arbol<T> arbol, T dato, Arbol<T> a1, Arbol<T> a2) {
		if(a1 == null && a2 == null)
			System.out.println("No se pueden juntar arboles nulos");
		else 
			if(a1 == null && a2 != null) {
				arbol.setRaiz(new NodoArbol<>(dato, null, a2.getRaiz()));
				if(!arbol.equals(a2))
					a2.setRaiz(null);
			}
			else 
				if(a1 != null && a2 == null) {
					arbol.setRaiz(new NodoArbol<>(dato, a1.getRaiz(), null));
					if(!arbol.equals(a1))
						a1.setRaiz(null);
				}
				else	
					if(a1.getRaiz().equals(a2.getRaiz()) && a1.raiz != null)
						System.out.println("no se pueden juntar " + a1.getNombre() + " y " + a2.getNombre() + ", son iguales");
					else {
						arbol.setRaiz(new NodoArbol<>(dato, a1.getRaiz(), a2.getRaiz()));
						if(!arbol.equals(a1))
							a1.setRaiz(null);
						if(!arbol.equals(a2))
							a2.setRaiz(null);
		}
	}
	
	public boolean buscar(T dato) {
		return buscar(this.getRaiz(), dato);
	}
	
	private boolean buscar(NodoArbol<T> arbol, T dato) {
		boolean resul = false;
		
		if(arbol != null) {
			if(arbol.getClave().compareTo(dato) == 0)
				resul = true;
			else {
				resul = buscar(arbol.getIz(), dato);
				if(!resul)
					resul = buscar(arbol.getDe(), dato);
			}
		}
		
		return resul;
	}
	
	public void eliminar(T dato) {
		this.setRaiz((new Eliminar()).borrarNodo(this.getRaiz(), dato));
	}
	
	
	class Eliminar{
		boolean encontrado = false;
		
		NodoArbol<T> borrarNodo(NodoArbol<T> arbol, T dato) {
			NodoArbol<T> p, aux;
			
			if(arbol != null)
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
					aux = borrarNodo(arbol.getIz(), dato);
					if(encontrado)
						arbol.setIz(aux);
					else {
						aux = borrarNodo(arbol.getDe(), dato);
						if(encontrado)
							arbol.setDe(aux);
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
			return resul;
		}
	}
	
	public int altura() {
		return altura(this.getRaiz());
	}
	
	public int altura(NodoArbol<T> arbol) {
		if(arbol == null)
			return 0;
		else
			return 1 + Math.max(altura(arbol.getIz()), altura(arbol.getDe()));
	}
	
	public int nivel(T dato) {
		if(this.getRaiz() != null)
			return nivel(this.getRaiz(), dato, -1, 1);
		else
			return 0;
	}
	
	private int nivel(NodoArbol<T> arbol, T dato, int nivelDato, int nivelActual) {
		if(arbol != null) {
			if(arbol.getClave().compareTo(dato) == 0) {
				nivelDato = nivelActual;
			}
			else {
				nivelDato = nivel(arbol.getIz(), dato, nivelDato, nivelActual+1);
				if(nivelDato == -1)
					nivelDato = nivel(arbol.getDe(), dato, nivelDato, nivelActual+1);
			}
				
		}
		return nivelDato;
	}
	
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
			System.out.println("clave:" + p.getClave() + " nivel:" + nivel(p.getClave()));
			if(p.getIz() != null)
				cola.encolar(p.getIz());
			if(p.getDe() != null)
				cola.encolar(p.getDe());
		}
	}
	
	public boolean esCompleto() {
		return esCompleto(this.getRaiz());
	}
	
	private boolean esCompleto(NodoArbol<T> arbol) {
		boolean resul = true;
		if(arbol != null) {
			if(altura(arbol.getIz()) != altura(arbol.getDe())) {
				resul = false;
			}
			else {
				resul = esCompleto(arbol.getIz()) && esCompleto(arbol.getDe());
			}			
		}
		return resul;
	}
	
	public int numeroDeNodos() {
		return numeroDeNodos(this.getRaiz());
	}
	
	private int numeroDeNodos(NodoArbol<T> arbol) {
		if(arbol != null) {
			return 1 + numeroDeNodos(arbol.getIz()) + numeroDeNodos(arbol.getDe());
		}
		else
			return 0;
	}
	
	public int numeroDeHojas() {
		return numeroDeHojas(this.getRaiz());
	}
	
	private int numeroDeHojas(NodoArbol<T> arbol) {
		if(arbol != null) {
			if(arbol.getDe() == null && arbol.getIz() == null)
				return 1;
			else
				return numeroDeHojas(arbol.getIz()) + numeroDeHojas(arbol.getDe());
		}
		else
			return 0;
	}
	
	public T menor() {
		return menor(this.getRaiz(), this.getRaiz().getClave());
	}
	
	private T menor(NodoArbol<T> arbol, T menor) {
		if(arbol != null) {
			if(arbol.getClave().compareTo(menor) < 0) {
				menor = arbol.getClave();
			}
			menor = menor(arbol.getIz(), menor);
			menor = menor(arbol.getDe(), menor);
		}
		return menor;	
	}
	
	public T mayor() {
		return mayor(this.getRaiz(), this.getRaiz().getClave());
	}
	
	private T mayor(NodoArbol<T> arbol, T mayor) {
		if(arbol != null) {
			if(arbol.getClave().compareTo(mayor) > 0) {
				mayor = arbol.getClave();
			}
			mayor = mayor(arbol.getIz(), mayor);
			mayor = mayor(arbol.getDe(), mayor);
		}
		return mayor;	
	}
	
	public void info() {
		if(this.getRaiz() != null) {
			System.out.println("Informacion del �rbol " + this.getNombre());
			System.out.println("Altura: " + this.altura());
			System.out.println("N�mero de nodos: " + this.numeroDeNodos());
			System.out.println("N�mero de hojas: " + this.numeroDeHojas());
			System.out.println("Arbol esta completo?: " + (this.esCompleto()?"SI":"NO"));
			System.out.println("Dato menor: " + this.menor());
			System.out.println("Dato mayor: " + this.mayor());
			System.out.println("Recorridos");
			System.out.println("PreOrder");
			this.preOrder();
			System.out.println("\nInOrder");
			this.inOrder();
			System.out.println("\nPostOrder");
			this.postOrder();
			System.out.println("\nAmplitud");
			this.listarAmplitud();
			System.out.println("\nAmplitud y niveles");
			this.listarAmplitudNiveles();
		}
	}

	@Override
	public String toString() {
		StringBuffer cadena = new StringBuffer(nombre + ": ");
		return inOrderToString(this.getRaiz(), cadena).toString();
	}
	
	private StringBuffer inOrderToString(NodoArbol<T> arbol, StringBuffer cadena) {
		if(arbol!=null) {			
			cadena = inOrderToString(arbol.getIz(), cadena);
			cadena.append(arbol.getClave() + " ");
			cadena = inOrderToString(arbol.getDe(), cadena);
		}
		return cadena;
		
			
	}
}







