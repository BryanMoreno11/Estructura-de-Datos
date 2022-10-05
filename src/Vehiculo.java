

public class Vehiculo implements Comparable<Vehiculo> {
	private String placa;

	/**
	 * @param placa
	 */
	public Vehiculo(String placa) {
		super();
		this.placa = placa;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + "]";
	}

	@Override
	public int compareTo(Vehiculo v) {
		return this.placa.compareTo(v.getPlaca());
	}
	
	
}
