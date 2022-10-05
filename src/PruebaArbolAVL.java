import arbolBinario.ArbolAVL;

public class PruebaArbolAVL {

	public static void main(String[] args) {
		//Ingresar enteros 65, 50, 23, 70, 82, 68 y 39
		ArbolAVL<Integer> avl1 = new ArbolAVL<>("AVL 1");
		ArbolAVL<String> avl2 = new ArbolAVL<String>("AVL 2", "Informacion");
		ArbolAVL<Libro> avl3 = new ArbolAVL<>("AVL 3");
		
		avl1.insertar(65);
		avl1.insertar(50);
		avl1.insertar(23);
		avl1.insertar(70);
		avl1.insertar(82);
		avl1.insertar(68);
		avl1.insertar(39);
		avl1.insertar(10);
		avl1.insertar(43);
		avl1.insertar(59);
		avl1.insertar(66);
		
		avl1.info();
		avl1.listarAmplitudNiveles();
		
		System.out.println("Eliminar el 82");
		avl1.eliminar(82);
		System.out.println("Eliminar el 10");
		avl1.eliminar(10);
		System.out.println("Eliminar el 39");
		avl1.eliminar(39);
		System.out.println("Eliminar la ra�z");
		avl1.eliminar(avl1.getRaiz().getClave());
		avl1.info();
		System.out.println("Eliminar el 70");
		avl1.eliminar(70);
		System.out.println("Eliminar el 68");
		avl1.eliminar(68);
		System.out.println("Eliminar el 66");
		avl1.eliminar(66);
		avl1.listarAmplitudNiveles();
		
		System.out.println("arbol de Strings");
		avl2.insertar("carrera");
		avl2.insertar("de");
		avl2.insertar("Ingenieria");
		avl2.insertar("en");
		avl2.insertar("Tecnologias");
		avl2.insertar("de");
		avl2.insertar("la");
		avl2.listarAmplitudNiveles();
		
		System.out.println("Insertar libros");
		avl3.insertar(new Libro("Biblia", 700));
		avl3.insertar(new Libro("Estructuras de Datos", 300));
		avl3.insertar(new Libro("Don Quijote", 500));
		avl3.insertar(new Libro("Ingenier�a de Datos", 200));
		avl3.insertar(new Libro("De la Tierra a la Luna", 15));
		avl3.listarAmplitudNiveles();

	}

}
