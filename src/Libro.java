
public class Libro implements Comparable<Libro>{
	private String titulo;
	private int numPaginas;
	
	/**
	 * @param titulo
	 * @param numPaginas
	 */
	public Libro(String titulo, int numPaginas) {
		super();
		this.titulo = titulo;
		this.numPaginas = numPaginas;
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the numPaginas
	 */
	public int getNumPaginas() {
		return numPaginas;
	}
	/**
	 * @param numPaginas the numPaginas to set
	 */
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	@Override
	public String toString() {
		return titulo + ":" + numPaginas;
	}

	@Override
	public int compareTo(Libro libro) {
		return this.numPaginas - libro.getNumPaginas();
	}
	
	

}
