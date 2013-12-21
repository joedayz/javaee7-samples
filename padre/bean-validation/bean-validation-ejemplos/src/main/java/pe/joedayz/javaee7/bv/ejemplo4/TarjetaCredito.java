package pe.joedayz.javaee7.bv.ejemplo4;

import javax.validation.constraints.NotNull;

public class TarjetaCredito {

	 // ======================================
	  // =             Attributes             =
	  // ======================================

	  @NotNull
	  private String numero;
	  @NotNull
	  private String fechaExpiracion;
	  @NotNull
	  private Integer numeroControl;
	  private String tipo;
	  
	  // ======================================
	  // =            Constructors            =
	  // ======================================

	  public TarjetaCredito() {
	  }

	  public TarjetaCredito(String numero, String fechaExpiracion,
			  Integer numeroControl, String tipo) {
	    this.numero = numero;
	    this.fechaExpiracion = fechaExpiracion;
	    this.numeroControl = numeroControl;
	    this.tipo = tipo;
	  }
	  
	  // ======================================
	  // =          Getters & Setters         =
	  // ======================================


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Integer getNumeroControl() {
		return numeroControl;
	}

	public void setNumeroControl(Integer numeroControl) {
		this.numeroControl = numeroControl;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	  
	  
	  
}
