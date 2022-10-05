package tadLista;

public class TadLista<T> implements Lista<T> {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private NodoLista<T> inicio;
	
	public TadLista() {
		this.inicio = null;
		this.nombre = "";
	}

	/**
	 * @param nombre
	 */
	public TadLista(String nombre) {
		this.nombre = nombre;
		this.inicio = null;
	}
	
	/**
	 * @param nombre
	 * @param inicio
	 */
	public TadLista(String nombre, NodoLista<T> inicio) {
		this.nombre = nombre;
		this.inicio = inicio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public void crearNodo () {
		/*Crea un nuevo nodo en el TadLista al principio de la lista*/
		inicio = new NodoLista<>(null, inicio);
	}	
	public T devolverClave () {
		/*Devuelve la clave contenida en el nodo del tadLista*/
		return inicio.clave;
	}	
	public NodoLista<T> devolverSiguiente () {
		/*Devuelve una referencia al siguiente del TadLista*/
		return inicio.sig;
	}	
	public NodoLista<T> devolverReferencia () {
		/*Devuelve una referencia al primer nodo del TadLista*/
		return inicio;
	}	
	public void asignarClave (T dato) {
		/*Asigna el dato al primer nodo del TadLista*/
		inicio.clave = dato;
	}	
	public void asignarReferencia (NodoLista<T> referencia) {
		/*Hace que el inicio del TadLista apunte al mismo sitio que referencia*/
		inicio = referencia;
	}	
	public void asignarReferenciaSiguiente (NodoLista<T> referenciaNueva) {
		/*Hace que el siguiente del nodo inicio apunte ahora al mismo sitio que referenciaNueva*/
		inicio.sig = referenciaNueva;
	}	
	public void asignarNulo () {
		/*Hace que el inicio del TadLista tome el valor null*/
		inicio = null;
	}	
	public boolean esNulo () {
		/*Devuelve true si el inicio del TadLista tiene valor null; false en caso contrario*/
		return inicio == null;
	}	
	public boolean esIgual (NodoLista<T> referencia) {
		/*Devuelve true si referencia apunta al mismo sitio que el inicio del TadLista, false en caso contrario*/
		return inicio == referencia;
	}	
	
	public void imprimirLista () {
		NodoLista<T> aux;
		
		aux = inicio;
		System.out.print("Lista " + this.nombre + ": ");
		while (aux != null) {
			System.out.print (aux.clave + " ");
			aux = aux.sig;
		}
		System.out.println ("FIN");
	}

	@Override
	public String toString() {
		return nombre + ": " + stringDeLista();
	}
	
	private String stringDeLista() {
		NodoLista<T> aux;
        StringBuffer cadena = new StringBuffer();
        aux = inicio;
        while(aux != null) {
        	cadena.append(aux.clave.toString());
        	cadena.append(" ");
            aux = aux.sig;
        }
        return cadena.toString();
	}
}