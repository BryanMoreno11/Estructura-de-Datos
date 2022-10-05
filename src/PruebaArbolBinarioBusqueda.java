import algoritmos.Algoritmos;
import arbolBinario.ArbolBB;

public class PruebaArbolBinarioBusqueda {

	public static void main(String[] args) {
		ArbolBB<Integer> abb1 = new ArbolBB<>("ArbolBB");
		ArbolBB<Persona> abb2 = new ArbolBB<>("ArbolBB Personas");
		Persona persona = new Persona("0701234567", 50);
		
		abb1.insertar(25);
		abb1.insertar(38);
		abb1.insertar(15);
		abb1.insertar(10);
		abb1.insertar(30);
		abb1.insertar(40);
		abb1.insertar(8);
		
		abb1.info();
		abb1.insertar(20);
		abb1.eliminar(8);
		abb1.info();
		
		//�rbol de personas
		
		for(int i=1; i<=12; ++i) {
			abb2.insertar(new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 30)));
		}
		abb2.insertar(persona);
		abb2.info();
		
		System.out.println("Buscar " + persona + (abb2.buscar(persona)?"ENCONTRADA":"NO ENCONTRADA"));
		System.out.println("Eliminar la raiz");
		abb2.eliminar(abb2.getRaiz().getClave());
		abb2.info();

	}

}
