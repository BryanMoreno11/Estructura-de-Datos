import algoritmos.Algoritmos;
import algoritmos.AlgoritmosColas;
import tadCola.Cola;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class PruebaTadCola {

	public static void main(String[] args) {
		Cola<Integer> cola1 = new TadCola<>();
		Cola<Vehiculo> cola2 = new TadCola<Vehiculo>("Cola de veh�culos");
		int dato;
		Vehiculo vehiculo;
		cola1.encolar(2);
		cola1.encolar(7);
		cola1.encolar(8);
		cola1.imprimirCola();
		
		try {
			System.out.println("Primero de la cola es: " + cola1.primero());
			System.out.println("Y tiene " + cola1.numElemCola() + " elementos");
		} catch (ColaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			dato = cola1.desencolar();
			System.out.println("Se desencol� el dato: " + dato);
		} catch (ColaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		cola1.imprimirCola();
		//invertir cola
		try {
			cola1.invertirCola();
			System.out.println("Se invirti� la cola");
		} catch (ColaVacia e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		cola1.imprimirCola();
		
		//cola de veh�culos
		System.out.println("Cola de veh�culos");
		cola2.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		cola2.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		cola2.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		cola2.encolar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		cola2.imprimirCola();
		
		try {
			vehiculo = cola2.desencolar();
			System.out.println("Se desencol�: " + vehiculo);
		} catch (ColaVacia e) {
			System.out.println(e.getMessage());
		}
		cola2.imprimirCola();
		System.out.println(cola2.getNombre() + " tiene " + AlgoritmosColas.contarCola(cola2) + " elementos");
		System.out.println("Estado de la cola como String");
		System.out.println(AlgoritmosColas.colaToString(cola2));
	}

}
