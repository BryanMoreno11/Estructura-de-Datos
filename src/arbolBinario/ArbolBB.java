package arbolBinario;

public class ArbolBB<T extends Comparable<T>> extends Arbol<T> {
	private static final long serialVersionUID = 1L;

	public ArbolBB() {
		super();
	}
	
	public ArbolBB(T clave) {
		super(clave);
	}
	
	public ArbolBB(String nombre, T clave) {
		super(nombre, clave);
	}
	
	public ArbolBB(String nombre) {
		super.setNombre(nombre);
		super.setRaiz(null);
	}
	
	public void insertar(T dato) {
		this.setRaiz(insertar(this.getRaiz(), dato));
	}
	
	private NodoArbol<T> insertar(NodoArbol<T> arbol, T dato) {
		NodoArbol<T> resul = arbol;
		if(arbol != null) 
			if(arbol.getClave().compareTo(dato) < 0)
				arbol.setDe(insertar(arbol.getDe(), dato));
			else
				if(arbol.getClave().compareTo(dato) > 0)
					arbol.setIz(insertar(arbol.getIz(), dato));
				else
					System.out.println("La clave ya existe");
		else
			resul = new NodoArbol<>(dato);
		return resul;
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
				if(arbol.getClave().compareTo(dato) > 0)
					resul = buscar(arbol.getIz(), dato);
				else
					resul = buscar(arbol.getDe(), dato);
			}
		}
		return resul;
	}	
	
	@Override
	public T mayor() {
		return mayor(this.getRaiz());
	}
	
	private T mayor(NodoArbol<T> arbol) {
		T mayor = null;
		if(arbol != null) {
			if(arbol.getDe() != null)
				mayor = mayor(arbol.getDe());
			else
				mayor = arbol.getClave();
		}
		return mayor;	
	}
	
	@Override
	public T menor() {
		return menor(this.getRaiz());
	}
	
	private T menor(NodoArbol<T> arbol) {
		T menor = null;
		if(arbol != null) {
			if(arbol.getIz() != null)
				menor = menor(arbol.getIz());
			else
				menor = arbol.getClave();
		}
		return menor;	
	}
	
	@Override
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
				if(arbol.getClave().compareTo(dato) > 0)
					nivelDato = nivel(arbol.getIz(), dato, nivelDato, nivelActual+1);
				else
					nivelDato = nivel(arbol.getDe(), dato, nivelDato, nivelActual+1);
			}			
		}
		return nivelDato;
	}
}
