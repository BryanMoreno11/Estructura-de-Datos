import algoritmos.Algoritmos;
import listaCalificadaOrdenada.Lista;

public class PruebaListaCalificadaOrdenada {

	public static void main(String[] args) {
		Lista<Vehiculo> lista1 = new Lista<>("Lista ordenada");
		
		lista1.insertar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		lista1.insertar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		lista1.insertar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		lista1.insertar(new Vehiculo(Algoritmos.generarPlacaAleatoria()));
		lista1.imprimirLista();
		System.out.println(lista1.leer(2));

	}

}
