package pe.joedayz.cdi.pagos;


import java.util.Calendar;

public class FuncionarioBuilder {

	private int anoAdmision;
	private Escolaridad escolaridadDeFuncionario;
	private Escolaridad escolaridadDeCargo;
	private double salarioBase;
	
	public FuncionarioBuilder() {
		escolaridadDeCargo = escolaridadDeFuncionario = Escolaridad.SUPERIOR;
		anoAdmision = Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public FuncionarioBuilder conTiempoDeServicioDe(int cantidad, int unidadDeTiempo){
		Calendar calendar = Calendar.getInstance();
		calendar.add(unidadDeTiempo, -cantidad);
		anoAdmision = calendar.get(Calendar.YEAR);
		
		return this;
	}
	
	public FuncionarioBuilder conEscolaridadInferior(){
		escolaridadDeFuncionario = Escolaridad.MEDIO;
		escolaridadDeCargo = Escolaridad.SUPERIOR;
		
		return this;
	}
	public FuncionarioBuilder conEscolaridadCorrecta(){
		escolaridadDeFuncionario = Escolaridad.SUPERIOR;
		escolaridadDeCargo = Escolaridad.SUPERIOR;
		
		return this;
	}
	public FuncionarioBuilder conEscolaridaPorArriba(){
		escolaridadDeFuncionario = Escolaridad.ESPECIALIZACION;
		escolaridadDeCargo = Escolaridad.SUPERIOR;
		
		return this;
	}
	
	public FuncionarioBuilder conSalarioBaseDe(double salarioBase){
		this.salarioBase = salarioBase;
		
		return this;
	}
	
	public Funcionario build(){
		Cargo cargo = new Cargo(salarioBase, escolaridadDeCargo);
		return new Funcionario("Fulano", cargo, escolaridadDeFuncionario, anoAdmision);
	}
}
