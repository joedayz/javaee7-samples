package pe.joedayz.cdi.pagos;

public class Cargo {

	private double salarioBase;
	private Escolaridad escolaridad;
	
	public Cargo(double salarioBase, Escolaridad escolaridade) {
		this.salarioBase = salarioBase;
		this.escolaridad = escolaridade;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public Escolaridad getEscolaridadDeseada() {
		return escolaridad;
	}

}
