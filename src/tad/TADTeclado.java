package tad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TAD para entradas por teclado utilizando BufferedReader
 * @author Fausto Redrovan
 * @version 10/05/2019
 */
public class TADTeclado {
	private InputStreamReader entrada;
	private BufferedReader teclado;
	
	public TADTeclado() {
		entrada = new InputStreamReader(System.in);
		teclado = new BufferedReader(entrada);
	}
	
	private void mensaje(String cadena) {
		System.out.println(cadena);
	}
	
	public int leerInt() throws NumberFormatException, IOException {
		return Integer.parseInt(teclado.readLine());
	}
	
	public int leerInt(String cadena) throws NumberFormatException, IOException {
		mensaje(cadena);
		return leerInt();
	}
	
	public double leerDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(teclado.readLine());
	}
	
	public double leerDouble(String cadena) throws NumberFormatException, IOException {
		mensaje(cadena);
		return leerDouble();
	}
	
	public String leerString() throws IOException {
		return teclado.readLine();
	}
	
	public String leerString(String cadena) throws IOException {
		mensaje(cadena);
		return teclado.readLine();
	}
	
	public char leerChar() throws IOException {
		return teclado.readLine().charAt(0);
	}
	
	public char leerChar(String cadena) throws IOException {
		mensaje(cadena);
		return leerChar();
	}
}
