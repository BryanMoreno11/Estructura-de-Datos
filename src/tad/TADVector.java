package tad;
import java.io.Serializable;
import java.util.Arrays;

public class TADVector<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T[] vector;
	private int longitud;
	private String nombre;

	@SuppressWarnings("unchecked")
	public TADVector(String nombre, int longitud) {
		this.setNombre(nombre);
		this.longitud = longitud;
		this.vector = (T[]) new Object[longitud];
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

	/**
	 * @return the longitud
	 */
	public int getLongitud() {
		return longitud;
	}
	
	

	/**
	 * M�todo para agregar un dato al vector en la primera posicion vacia
	 * @param dato El dato a ingresar al vector
	 * @return true si el ingreso fue exitoso o false si el vector esta lleno
	 */
	public boolean ingresarElemento(T dato) {
		boolean resul = false;
		int pos=0;
		
		do {
			if(vector[pos]==null) {
				vector[pos]=dato;
				resul = true;
				pos=vector.length;
			}
			pos++;
		}while(pos<vector.length);
		
		return resul;		
	}
	
	public boolean ingresarElemento(T dato, int pos) {
		boolean resul=false;
		
		if(pos>=0 && pos<vector.length && vector[pos]==null) {
			vector[pos] = dato;
			resul = true;
		}
		
		return resul;
	}
	
	public T leerElemento(int pos) {
		T resul = null;
		
		if(pos>=0 && pos<vector.length) {
			resul = vector[pos];
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
		for(int pos=0; pos<vector.length; ++pos)
			System.out.println(pos + ": " + leerElemento(pos));
	}
	
	public boolean modificarElemento(T dato, int pos) {
		boolean resul=false;
		
		if(pos>=0 && pos<vector.length && vector[pos]!=null) {
			vector[pos] = dato;
			resul = true;
		}		
		return resul;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(null, pos);
	}

	@Override
	public String toString() {
		return "TADVector: " + nombre + " [vector=" + Arrays.toString(vector) + ", longitud=" + longitud + "]";
	}

	
}
