package algoritmos;

public class Algoritmos {	
	
	/**
	 * Metodo recursivo para sumar enteros desde 1 hasta n
	 * @param n Limite de la suma
	 * @return Resultado de sumar los enteros desde el 1 hasta n
	 */
	public static int suma(int n) {
		if(n==1)
			return 1;
		else
			return n + suma(n-1);
	}
	
	/**
	 * Metodo 2 para sumar enteros desde 1 hasta n
	 * utilizando un metodo recursivo de cola
	 * @param n Limite de la suma
	 * @return Resultado de sumar los enteros desde el 1 hasta n
	 */
	public static int sumaR(int n) {
		return sumaR(n, 0);
	}
	
	/**
	 * M�todo recursivo 2 para sumar enteros desde 1 hasta n
	 * @param n Limite de la suma
	 * @return Resultado de sumar los enteros desde el 1 hasta n
	 */
	private static int sumaR(int n, int sum) {
		sum+=n;
		if(n>1)
			sum = sumaR(n-1,sum);		
		return sum;
	}
	
	/**
	 * M�todo recursivo para sumar enteros desde n hasta m, donde n <= m
	 * @param n Valor inicial de la suma
	 * @param m Limite de la suma
	 * @return Resultado de sumar los enteros desde el n hasta m, o m si n>m
	 */
	public static int suma(int n, int m) {
		if(n < m)
			return n + suma(n+1, m);
		else
			return m;
	}
	
	/**
	 * Determina si num es un numero primo o no
	 * @param num Numero para determinar si es primo o no
	 * @return True si num es primo, False si no lo es
	 */
	public static boolean esPrimo(int num) {
		return esPrimo(num, 2);
	}

	/**
	 * M�todo recursivo para determinar si num es numero primo
	 * @param num Numero entero a saber si es primo
	 * @param div Divisor de prueba
	 * @return True si num es primo, False si no lo es
	 */
	private static boolean esPrimo(int num, int div) {
		if(num/2 < div)
			return true;
		else
			if(num % div == 0)
				return false;
			else
				return esPrimo(num, div+1);				
	}
	
	/**
	 * Muestra en pantalla los n primeros n�meros primos
	 * @param n Cantidad de numeros primos requeridos
	 */
	public static void nPrimos(int n) {
		nPrimos(n, 2);
	}
	
	/**
	 * M�todo recursivo que muestra en pantalla los n primeros numeros primos
	 * @param n Cantidad de numeros primos requeridos
	 * @param num N�mero a verificar si es primo o no
	 */
	private static void nPrimos(int n, int num) {
		if(n>=1)
			if(esPrimo(num)) {
				System.out.println(num);
				nPrimos(n-1, num+1);
			}
			else
				nPrimos(n,num+1);
	}
	
	/**
	 * Inicializa el metodo recursivo que imprime en pantalla el contenido de un arreglo unidimensional
	 * @param <T> Clase generica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean imprimir en pantalla
	 */
	public static <T> void imprimirVector(T[] vector) {
		imprimirVector(vector, 0);
	}
	
	/**
	 * M�todo recursivo para imprimir en pantalla el contenido de un arreglo unidimensional
	 * @param <T> Clase generica que indica el tipo de objeto del vector
	 * @param vector Vector cuyos elementos se desean imprimir en pantalla
	 * @param pos Posici�n inicial
	 */
	private static <T> void imprimirVector(T[] vector, int pos) {
		if(pos>=0 && pos<vector.length) {
			System.out.println(vector[pos]);
			imprimirVector(vector, pos+1);
		}
	}
	
	/**
	 * Genera un numero entero aleatorio en un rango, entre <em>m</em> y <em>n</em> (<em>m</em> &lt; <em>n</em>).
	 * @param m Valor inicial del rango
	 * @param n Valor final del rango
	 * @return N�mero entero aleatorio en el rango dado
	 */
	public static int aleatorio(int m, int n) {
		return (int)redondearDecimales(Math.random()*(n-m)+m, 0);
	}
	
	/**
	 * Genera un n�mero real aleatorio en un rango, entre <em>m</em> y <em>n</em> (<em>m</em> &lt; <em>n</em>) con un numero de decimales dado.
	 * @param m Valor inicial del rango
	 * @param n Valor final del rango
	 * @param numeroDecimales Numero de decimales que se requieren en el numero generado
	 * @return N�mero real aleatorio en el rango y con numero de decimales dados
	 */
	public static double aleatorio(int m, int n, int numeroDecimales) {
		return redondearDecimales(Math.random()*(n-m)+m, numeroDecimales);
	}
	
	/**
	 * Redondea un numero real <em>valor</em> al n�mero de decimales <em>numeroDecimales</em> dado.
	 * @param valor Numero real a redondear
	 * @param numeroDecimales Numero de decimales que se requieren
	 * @return Numero real redondeado al numero de decimales dado
	 */
	public static double redondearDecimales(double valor, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valor;
		parteEntera = Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
		return resultado;
	}
	
	/**
	 * Genera el digito verificador que valida una cedula. 
	 * Solo se requieren los primeros 9 digitos de la cedula. 
	 * @param cedula9 Los primeros 9 digitos de una cedula
	 * @return D�gito verificador que es el decimo digito de la cedula
	 */
	public static int generarVerificadorDeCedula(String cedula9) {
		int verificador, tercerDigito;
		int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int suma, digito;
		
		try {

			if (cedula9.length() == 9) // Solo 9 d�gitos el d�cimo es el verificador
			{
				tercerDigito = Integer.parseInt(cedula9.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validaci�n c�dula
					// El d�cimo d�gito se lo considera d�gito verificador
					suma = 0;
					digito = 0;
					for (int i = 0; i < cedula9.length(); i++) {
						digito = Integer.parseInt(cedula9.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if (suma % 10 == 0) {
						verificador = suma % 10;
					}
					else{
						verificador = 10 - (suma % 10);
					} 
				}else {
					verificador = -1;
				}
			}else {
				verificador = -1;
			}
		} catch (NumberFormatException nfe) {
			verificador = -1;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de generaci�n");
			verificador = -1;
		}
		return verificador;
	}
	
	/**
	 * Genera un numero de cedula por provincia (c�digo de 2 caracteres)
	 * @param provincia Codigo de provincia. Para El Oro es 07
	 * @return Un numero de c�dula aleatorio de la provincia
	 */
	public static String cedulaAleatorio(String provincia) {
		StringBuffer cedula9 = new StringBuffer();
		int decimoDigito;

		do {
			cedula9.delete(0, cedula9.length()); //vac�a el StringBuffer
			for(int i=3; i<=9; ++i) { //genera 9 d�gitos
				cedula9.append((int)aleatorio(0,9,0)); //del 0 al 9
			}
			cedula9.insert(0, provincia);
			decimoDigito = generarVerificadorDeCedula(cedula9.toString());
		}while(decimoDigito < 0);
		return cedula9.toString() + decimoDigito;
	}
	
	/**
	 * Genera un numero de cedula aleatorio de acuerdo a las 24 provincias.
	 * Utiliza una clase Enum Provincia con el c�digo de cada una.
	 * @return Un numero de cedula aleatorio de una de las 24 provincias
	 */
	public static String cedulaAleatorio() {
		int provincia;
		
		provincia = aleatorio(1, Provincia.values().length);
		if(provincia < 10)
			return cedulaAleatorio("0" + String.valueOf(provincia));
		else
			return cedulaAleatorio(String.valueOf(provincia));			
	}
	
	/**
	 * Genera de manera aleatoria una letra mayuscula entre A y Z
	 * @return Letra mayuscula aleatoria
	 */
	public static char letraMayAleatoria() {
		return (char)aleatorio(65, 90);
	}
	
	/**
	 * Genera de manera aleatoria una letra minuscula entre a y z
	 * @return Letra minuscula aleatoria
	 */
	public static char letraMinAleatoria() {
		return (char)aleatorio(97, 122);
	}
	
	/**
	 * Genera un n�mero de placa de veh�culo aleatoria
	 * @return N�mero de placa de la forma AAA-0000
	 */
	public static String generarPlacaAleatoria() {
		StringBuffer placa = new StringBuffer();
		for(int i=1; i<=3; ++i)
			placa.append(Provincia.values()[aleatorio(0, 23)].getCodigo());
		placa.append('-');
		for(int i=1; i<=4; ++i)
			placa.append(aleatorio(0, 9));
		return placa.toString();
	}
	
	/**
	 * Genera un numero de placa de vehiculo aleatoria,
	 * de acuerdo al codigo de provincia dado. El Oro es 7 por ejemplo.
	 * @param provincia Codigo de la provincia
	 * @return Numero de placa de la forma AAA-0000 o null si el codigo dado no es valido.
	 */
	public static String generarPlacaAleatoria(int provincia) {
		if(provincia>=1 && provincia<=24) {
			StringBuffer placa = new StringBuffer();
			placa.append(Provincia.values()[provincia-1].getCodigo());
			for(int i=1; i<=2; ++i)
				placa.append(Provincia.values()[aleatorio(0, 23)].getCodigo());
			placa.append('-');
			for(int i=1; i<=4; ++i)
				placa.append(aleatorio(0, 9));
			return placa.toString();
		}
		else
			return null;
	}
}
