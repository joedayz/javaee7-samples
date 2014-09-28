package pe.joedayz.ventas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pe.joedayz.ventas.controller.DecimalPositivo;

@Entity
@Table(name="movimiento")
public class Movimiento implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1683303075400653123L;
	private Long id;
	private Persona persona;
	private String descripcion;
	private BigDecimal valor;
	private TipoMovimiento tipo;
	private Date fechaVencimiento;
	private Date fechaPago;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name="persona_id")
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	@NotEmpty
	@Size(max=80)
	@Column(length=80, nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@DecimalPositivo
	@Column(precision=10, scale=2, nullable=false)
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public TipoMovimiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento", nullable=false)
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago", nullable=true)	
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimiento other = (Movimiento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", persona=" + persona
				+ ", descripcion=" + descripcion + ", valor=" + valor
				+ ", tipo=" + tipo + ", fechaVencimiento=" + fechaVencimiento
				+ ", fechaPago=" + fechaPago + "]";
	}
	
	
	
}
