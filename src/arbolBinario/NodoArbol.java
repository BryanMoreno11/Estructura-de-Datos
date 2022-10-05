package arbolBinario;

import java.io.Serializable;

public class NodoArbol<T extends Comparable<T>> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T clave;
	private int fe;
	private NodoArbol<T> iz;
	private NodoArbol<T> de;
	
	public NodoArbol() {
		this.setClave(null);
		this.setIz(null);
		this.setDe(null);
	}

	public NodoArbol(T clave, NodoArbol<T> iz, NodoArbol<T> de) {
		this.setClave(clave);
		this.setIz(iz);
		this.setDe(de);
	}

	public NodoArbol(T clave) {
		this.setClave(clave);
		this.setIz(null);
		this.setDe(null);
	}

	public T getClave() {
		return clave;
	}

	public void setClave(T clave) {
		this.clave = clave;
	}

	/**
	 * @return the fe
	 */
	public int getFe() {
		return fe;
	}

	/**
	 * @param fe the fe to set
	 */
	public void setFe(int fe) {
		this.fe = fe;
	}

	public NodoArbol<T> getIz() {
		return iz;
	}

	public void setIz(NodoArbol<T> iz) {
		this.iz = iz;
	}

	public NodoArbol<T> getDe() {
		return de;
	}

	public void setDe(NodoArbol<T> de) {
		this.de = de;
	}
}
