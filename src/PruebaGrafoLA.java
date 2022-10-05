import algoritmos.AlgoritmosGrafos;
import grafos.GrafoLA;



public class PruebaGrafoLA {

	

	public static void main(String[] args) {
		GrafoLA grafo1= new GrafoLA(10, true);
		GrafoLA grafo2= new GrafoLA(5, false);
		GrafoLA grafoCT;
		int [][] MC;
		grafo1.setNombre("Grafo1");
		grafo1.insertaVertice(8);
		grafo1.insertaArista(0, 1);
		grafo1.insertaArista(2, 4);
		grafo1.insertaArista(2, 5);
		grafo1.insertaArista(2, 6);
		grafo1.insertaArista(4, 6);
		grafo1.insertaArista(5, 6);
		grafo1.insertaArista(5, 7);
		grafo1.insertaArista(6, 4);
		grafo1.insertaArista(6, 7);
		AlgoritmosGrafos.estadoGrafo(grafo1);
		System.out.println("El grafo "+grafo1.getNombre()+(!AlgoritmosGrafos.tieneCiclos(grafo1)?"NO":"")+" tiene ciclos");
		System.out.println("Matriz de caminos");
		MC= AlgoritmosGrafos.matrizCaminos(grafo1);
		AlgoritmosGrafos.imprimirMatriz(MC);
		System.out.println("Caminos de longitud 2 del 2 al 7: "+AlgoritmosGrafos.caminos(grafo1, 2, 2, 7));
		System.out.println("Caminos de longitud 3 del 2 al 7: "+AlgoritmosGrafos.caminos(grafo1, 3, 2, 7));
		System.out.println("Cierre Transitivo del grafo "+grafo1.getNombre());
		grafoCT= (GrafoLA)AlgoritmosGrafos.getGrafo(MC, false);
		grafoCT.setNombre("CT de Grafo 1");
		AlgoritmosGrafos.estadoGrafo(grafoCT);
		//Implementación del grafo 2
		System.out.println("GRAFO 2");
		grafo2.setNombre("grafo 2");
		grafo2.insertaVertice(5);
		grafo2.insertaArista(0, 2);
		grafo2.insertaArista(1, 2);
		grafo2.insertaArista(1, 3);
		grafo2.insertaArista(2, 4);
		grafo2.insertaArista(3, 4);
		AlgoritmosGrafos.estadoGrafo(grafo2);
	}

}
