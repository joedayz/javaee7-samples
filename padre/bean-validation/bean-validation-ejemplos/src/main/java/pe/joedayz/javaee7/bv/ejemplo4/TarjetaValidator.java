package pe.joedayz.javaee7.bv.ejemplo4;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class TarjetaValidator {

	private ValidationAlgorithm validationAlgorithm;

	// ======================================
	// = Constructors =
	// ======================================

	public TarjetaValidator() {
	}

	public TarjetaValidator(@NotNull ValidationAlgorithm validationAlgorithm) {
		this.validationAlgorithm = validationAlgorithm;
	}

	
	  // ======================================
	  // =           Public Methods           =
	  // ======================================

	  @AssertTrue
	  public Boolean validate(@NotNull @Valid TarjetaCredito tarjetaCredito) {

	    String ultimoDigito = validationAlgorithm.validate(tarjetaCredito.getNumero(),
	    		tarjetaCredito.getNumeroControl());

	    if (Integer.parseInt(ultimoDigito.toString()) % 2 == 0) {
	      return true;
	    } else {
	      return false;
	    }
	  }

	  @AssertTrue
	  public Boolean validate(@NotNull String numero, @Future Date fechaExpiracion,
			  @NotNull Integer numeroControl, String tipo) {

	    String ultimoDigito = validationAlgorithm.validate(numero, 
	    		numeroControl);

	    if (Integer.parseInt(ultimoDigito.toString()) % 2 == 0) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	
	private class ValidationAlgorithm {

		public String validate(String numero, Integer numeroControl) {
			Character ultimoDigito = numero.charAt(numero.length() - 1);
			return ultimoDigito.toString();
		}
	}
}
