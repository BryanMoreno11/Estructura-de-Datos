import algoritmos.AlgoritmosPilas;
import tadPila.Pila;
import tadPila.PilaVacia;
import tadPila.TadPila;

public class PruebaTadPila {

	public static void main(String[] args) {
		Pila<Integer> pila1 = new TadPila<>();
		Pila<Libro> pila2 = new TadPila<Libro>("Pila de libros");
		int dato;
		Libro libro;
		
		pila1.apilar(2);
		pila1.apilar(8);
		pila1.apilar(7);
		
		pila1.imprimirPila();
		try {
			AlgoritmosPilas.ordenarMayorPila(pila1);
		} catch (PilaVacia e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		pila1.imprimirPila();
		try {
			System.out.println("Cima de la pila es: " + pila1.cima());
			System.out.println("Y tiene " + pila1.numElemPila() + " elementos");
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//desapilar
		try {
			dato = pila1.desapilar();
			System.out.println("Dato desapilado: " + dato);
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		pila1.imprimirPila();
		
		//decapitar
		try {
			pila1.decapitar();
			System.out.println("Se ha eliminado la cima");
		} catch (PilaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		pila1.imprimirPila();
		pila1.eliminarPila();
		System.out.println("Se ha borrado la pila");
		pila1.imprimirPila();
		
		//pila de libros
		System.out.println("Pila de libros");
		pila2.apilar(new Libro("Huasipungo", 200));
		pila2.apilar(new Libro("Estructuras de Datos", 300));
		pila2.apilar(new Libro("Estructuras de Datos para Dummies", 25));
		pila2.imprimirPila();
		System.out.println(pila2);
		try {
			System.out.println("La pila tiene " + AlgoritmosPilas.contarPila(pila2) + " libros");
		} catch (PilaVacia e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Sumergir libro");
		try {
			AlgoritmosPilas.sumergir(pila2, new Libro("Cien a�os de soledad", 250) );
		} catch (PilaVacia e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pila2.imprimirPila();
		
		try {
			libro = pila2.desapilar();
			System.out.println("Se desapil� " + libro);
		} catch (PilaVacia e) {
			System.out.println(e.getMessage());
		}
		pila2.imprimirPila();
		System.out.println("Estado de la pila como String");
		System.out.println(AlgoritmosPilas.pilaToString(pila2));
		
	}

}
