import algoritmos.AlgoritmosListas;
import tadLista.Lista;
import tadLista.TadLista;

public class TutoriaLista {

	public static void main(String[] args) {
		Lista<Integer> lista;
		lista = new TadLista<>("MiLista");
		
		AlgoritmosListas.insertarAlFinal(lista, 15);
		AlgoritmosListas.insertarAlPrincipio(lista, 8);
		//Ingresar el 9 entre el 8 y el 15
		
		lista.imprimirLista();

	}

}
