package pe.joedayz.ventas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.ventas.model.Movimiento;
import pe.joedayz.ventas.model.Persona;
import pe.joedayz.ventas.model.TipoMovimiento;
import pe.joedayz.ventas.repository.MovimientoRepository;
import pe.joedayz.ventas.repository.PersonaRepository;
import pe.joedayz.ventas.service.NegocioException;
import pe.joedayz.ventas.service.RegistroMovimientos;

@Named
@ViewScoped
public class RegistroMovimientosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RegistroMovimientos registroMovimientos;
	
	@Inject
	private PersonaRepository personaRepository;
	
	@Inject
	private MovimientoRepository movimientoRepository;
	
	private Movimiento movimiento = new Movimiento();
	private List<Persona> todasPersonas;
	
	public void prepararRegistro(){
		this.todasPersonas = this.personaRepository.todas();
		
		if(this.movimiento==null){
			this.movimiento = new Movimiento();
		}
	}
	
	public void guardar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try{
		
			this.registroMovimientos.guardar(this.movimiento);
			
			this.movimiento = new Movimiento();
			context.addMessage(null,new FacesMessage("Movimiento grabado con exito!"));
			
			
		}catch(NegocioException e){
			
			FacesMessage mensaje = new FacesMessage(e.getMessage());
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null,  mensaje);
		}
	}


	
	public List<String> obtenerDescripciones(String descripcion){
		return this.movimientoRepository.descripcionesQueContienen(descripcion);
	}
	
	public List<Persona> getTodasPersonas() {
		return todasPersonas;
	}

	public void setTodasPersonas(List<Persona> todasPersonas) {
		this.todasPersonas = todasPersonas;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	
	public TipoMovimiento[] getTiposMovimientos(){
		return TipoMovimiento.values();
	}
	
	public void fechaVencimientoModificada(AjaxBehaviorEvent event){
		if(this.movimiento.getFechaPago() == null){
			this.movimiento.setFechaPago(this.movimiento.getFechaVencimiento());
		}
	}
	
	
}
