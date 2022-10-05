import algoritmos.Algoritmos;
import algoritmos.Busqueda;
import algoritmos.Ordenacion;

public class PruebaOrdenacionBusqueda {

	public static void main(String[] args) {
		Persona p1 = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 35));
		Persona p2 = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 35));
		Persona p3;
		Persona[] vector1 = new Persona[5];
		Vehiculo[] vector2 = new Vehiculo[5];
		int pos;
		
		
		System.out.println("Personas generadas");
		System.out.println(p1);
		System.out.println(p2);
		if(p1.compareTo(p2) > 0)
			System.out.println(p1.getCedula() + " es mayor");
		else
			if(p1.compareTo(p2) < 0)
				System.out.println(p2.getCedula() + " es mayor");
			else
				System.out.println("Son iguales");
		
		vector1[0] = p1;
		vector1[1] = p2;
		for(pos=2; pos<vector1.length; ++pos)
			vector1[pos] = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 35));
		System.out.println("Vector de personas");
		for(Persona p : vector1)
			System.out.println(p);
		
		System.out.println("Busqueda de " + p1);
		pos = Busqueda.buscarSecuencial(p1, vector1);
		System.out.println(pos==-1?"NO ENCONTRADO":"ENCONTRADO en la posicion: " + pos);
		p3 = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 35));
		System.out.println("Busqueda de " + p3);
		pos = Busqueda.buscarSecuencial(p3, vector1);
		System.out.println(pos==-1?"NO ENCONTRADO":"ENCONTRADO en la posicion: " + pos);
		
		
		System.out.println("Vector de personas ordenado");
		Ordenacion.bubbleSortR(vector1);
		for(Persona p : vector1)
			System.out.println(p);
		
		System.out.println("Busqueda de " + p1);
		pos = Busqueda.buscarBinaria(p1, vector1);
		System.out.println(pos==-1?"NO ENCONTRADO":"ENCONTRADO en la posicion: " + pos);
		p3 = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 35));
		System.out.println("Busqueda de " + p3);
		pos = Busqueda.buscarBinaria(p3, vector1);
		System.out.println(pos==-1?"NO ENCONTRADO":"ENCONTRADO en la posicion: " + pos);
		
		
		for(pos=0; pos<vector2.length; ++pos)
			vector2[pos] = new Vehiculo(Algoritmos.generarPlacaAleatoria());
		System.out.println("Vector de Vehiculos");
		for(Vehiculo v : vector2)
			System.out.println(v);
		
		System.out.println("Vector de Vehiculos ordenado");
		Ordenacion.quickSort(vector2);
		for(Vehiculo v : vector2)
			System.out.println(v);
		
	}

}
