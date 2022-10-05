

public class Persona implements Comparable<Persona> {
	private String cedula;
	private int edad;
	
	/**
	 * @param cedula
	 * @param edad
	 */
	public Persona(String cedula, int edad) {
		super();
		this.cedula = cedula;
		this.edad = edad;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", edad=" + edad + "]";
	}

	@Override
	public int compareTo(Persona p) {
		if(this.edad < p.getEdad())
			return -1;
		else
			if(this.edad > p.getEdad())
				return 1;
			else
				return this.cedula.compareTo(p.getCedula());
	}
	
	

}
