import java.io.IOException;

import tad.TADArreglo;
import tad.TADTeclado;
//import tad.TADVector;

public class PruebasTAD {

	public static void main(String[] args) {
		int n=4;
		boolean hayError;
		TADTeclado teclado = new TADTeclado();
		//TADVector<Integer> vector1 = new TADVector<>("Vector1", n);
		TADArreglo<Integer> vector1 = new TADArreglo<>("Vector1", n);
		
		System.out.println("Ingrese " + n + " numeros enteros");
		for(int i=1; i<=n; ++i) {			
			do {
				hayError = false;
				try {
					vector1.ingresarElemento(teclado.leerInt("Ingrese entero #" + i + ": "));
				} catch (NumberFormatException e) {
					System.out.println("Error. Ingrese nuevamente un numero entero.");
					hayError = true;
				} catch (IOException e) {
					System.out.println("Error desconocido. Ingrese nuevamente un numero entero.");
					hayError = true;
				}
			}while(hayError);
		}
		
		vector1.imprimirVectorCompleto();

	}

}
