import arbolBinario.Arbol;

public class PruebaArbolBinario {

	public static void main(String[] args) {
		Arbol<Integer> a3 = new Arbol<Integer>("a3", 3);
		Arbol<Integer> a5 = new Arbol<>();
		
		Arbol<Integer> a9 = new Arbol<Integer>("a9", 9);
		Arbol<Integer> a4 = new Arbol<Integer>("a4", 4);
		Arbol<Integer> a8 = new Arbol<>();
		
		Arbol<Integer> a7 = new Arbol<>();
		
		Arbol.juntar(a5, 5, a3, null);
		Arbol.juntar(a8, 8, a9, a4);
		Arbol.juntar(a7, 7, a5, a8);
		a7.setNombre("a7");
		a7.info();
		System.out.println("eliminar la raiz");		
		a7.eliminar(a7.getRaiz().getClave());
		System.out.println(a7);
		System.out.println("Buscar el 8: " + (a7.buscar(8)?"ENCONTRADO":"NO ENCONTRADO"));
		
	}

}
