import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.TadLista;

public class PruebaTadLista {

	public static void main(String[] args) {
		Lista<Integer> lista = new TadLista<>("MiLista");
		Lista<Integer> lista1 = new TadLista<>("Copia 1 MiLista");
		Lista<Integer> lista2 = new TadLista<>("Copia 2 MiLista");
		
		System.out.println("Insertando datos al principio se crea lista: 8, 4, 3, 7");
		AlgoritmosListas.insertarAlPrincipio(lista, 7);
		AlgoritmosListas.insertarAlPrincipio(lista, 3);
		AlgoritmosListas.insertarAlPrincipio(lista, 4);
		AlgoritmosListas.insertarAlPrincipio(lista, 8);
		lista.imprimirLista();
		AlgoritmosListas.ordenarMenor(lista);
		lista.imprimirLista();
		//contar elementos
		System.out.println("N�mero de elementos de la Lista " + lista.getNombre() + ": " + AlgoritmosListas.contar(lista));
		
		//eliminar el primero
		System.out.println(AlgoritmosListas.eliminarPrimero(lista)?"Se elimina el primero de la lista":"No se pudo eliminar el primero de la lista");
		lista.imprimirLista();
		
		//insertar al final
		System.out.println("Se inserta al final de la lista el 99");
		AlgoritmosListas.insertarAlFinal(lista, 99);
		lista.imprimirLista();
		
		//duplicar lista m�todo 1
		System.out.println("Se copia la lista. M�todo 1");
		AlgoritmosListas.duplicarLista1(lista, lista1);
		lista1.imprimirLista();
		
		//duplicar lista m�todo 2
		System.out.println("Se copia la lista. M�todo 2");
		AlgoritmosListas.duplicarLista2(lista, lista2);
		lista2.imprimirLista();
		
		//buscar datos
		System.out.println("Se busca el dato 4: " + (AlgoritmosListas.buscar(lista, 4)?"ENCONTRADO":"NO ENCONTRADO"));
		System.out.println("Se busca el dato 5: " + (AlgoritmosListas.buscar(lista, 5)?"ENCONTRADO":"NO ENCONTRADO"));
		
		//insertar luego de un dato
		System.out.println("Se inserta el 55 luego del 7");
		System.out.println(AlgoritmosListas.insertar(lista1, 55, 7)?"Insertado":"No insertado");
		lista1.imprimirLista();
		
		//insertar en una posici�n
		System.out.println("Se inserta el 22 en la posici�n 3");
		System.out.println(AlgoritmosListas.insertarPos(lista1, 22, 6)?"Insertado":"No insertado");
		lista1.imprimirLista();
	}

}
