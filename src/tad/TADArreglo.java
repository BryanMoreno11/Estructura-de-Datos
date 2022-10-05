package tad;

import java.io.Serializable;
import java.util.ArrayList;

public class TADArreglo<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<T> vector;
	private int longitud;
	private String nombre;
	
	/**
	 * @param vector
	 * @param longitud
	 */
	public TADArreglo(String nombre, int longitud) {
		this.setNombre(nombre);
		this.vector = new ArrayList<>(longitud);
		this.longitud = longitud;
		for(int pos=0; pos<longitud; ++pos)
			vector.add(null);
	}
	
	/**
	 * @return the longitud
	 */
	public int getLongitud() {
		return longitud;
	}
	
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

	public boolean ingresarElemento(T dato) { //complejidad O(n)
		boolean resul = false; 
		int pos=0;
		
		do {
			if(vector.get(pos) == null) {
				vector.set(pos, dato);
				resul = true;
				pos=vector.size();
			}
			pos++;			
		}while(pos<vector.size());
		return resul;		
	}
	
	public boolean ingresarElemento(T dato, int pos) { //O(1)
		boolean resul = false;
		
		if(pos>=0 && pos<vector.size() && vector.get(pos)==null) {
			vector.set(pos, dato);
			resul=true;
		}
			
		return resul;		
	}
	
	public boolean modificarElemento(T dato, int pos) {
		boolean resul = false;
		
		if(pos>=0 && pos<vector.size() && vector.get(pos)!=null) {
			vector.set(pos, dato);
			resul=true;
		}
			
		return resul;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(null, pos);
	}
	
	public T leerElemento(int pos) {
		T resul = null;
		if(pos>=0 && pos<vector.size()) {
			resul = vector.get(pos);
		}
		return resul;
	}
	
	public void imprimirVector() {
		for(T elem : vector) {
			if(elem != null)
				System.out.println(elem);
		}
	}
	
	public void imprimirVectorCompleto() {
		for(int pos=0; pos<vector.size(); ++pos)
			System.out.println(pos + ": " + leerElemento(pos));
	}

	@Override
	public String toString() {
		return "TADArreglo [vector=" + vector + ", longitud=" + longitud + "]";
	}
	
	
}
