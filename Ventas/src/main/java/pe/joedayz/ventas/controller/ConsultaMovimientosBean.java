package pe.joedayz.ventas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.ventas.model.Movimiento;
import pe.joedayz.ventas.repository.MovimientoRepository;
import pe.joedayz.ventas.service.NegocioException;
import pe.joedayz.ventas.service.RegistroMovimientos;


@Named
@ViewScoped
public class ConsultaMovimientosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private RegistroMovimientos registroMovimiento;
	
	@Inject
	private MovimientoRepository movimientoRepository;
	
	private List<Movimiento> movimientos;
	
	
	private Movimiento movimientoSeleccionado;
	
	public void consultar(){
		this.movimientos = movimientoRepository.todos();
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public void eliminar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			this.registroMovimiento.eliminar(this.movimientoSeleccionado);
			this.consultar();
			
			context.addMessage(null, new FacesMessage("Movimiento eliminado con exito"));
			
		}catch(NegocioException ex){
			FacesMessage mensaje = new FacesMessage(ex.getMessage());
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensaje);
		}
	}

	public Movimiento getMovimientoSeleccionado() {
		return movimientoSeleccionado;
	}

	public void setMovimientoSeleccionado(Movimiento movimientoSeleccionado) {
		this.movimientoSeleccionado = movimientoSeleccionado;
	}
	
	
	
}
