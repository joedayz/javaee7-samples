package pe.joedayz.cdi.pagos;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Vetoed;

@Vetoed
public class CalculadoraDeSalariosMock implements CalculadoraDeSalarios{

	private double salarioFijo;

	public CalculadoraDeSalariosMock(double salarioFijo){
		this.salarioFijo = salarioFijo;
	}
	public double calculaSalario(Funcionario funcionario){
		return salarioFijo;
	}
}
