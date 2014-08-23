package com.mycompany.finanzas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mycompany.finanzas.exception.NegocioException;
import com.mycompany.finanzas.modelo.Movimiento;
import com.mycompany.finanzas.modelo.Persona;
import com.mycompany.finanzas.modelo.TipoMovimiento;
import com.mycompany.finanzas.repository.MovimientosRepository;
import com.mycompany.finanzas.repository.PersonaRepository;
import com.mycompany.finanzas.service.RegistroMovimientos;
import com.mycompany.finanzas.util.JpaUtil;

@ManagedBean
@ViewScoped
public class RegistroMovimientoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Movimiento movimiento = new Movimiento();
	private List<Persona> todasPersonas;
	
	public void prepararRegistro(){
		EntityManager manager = JpaUtil.getEntityManager();
		try{
			PersonaRepository personaRepository = new PersonaRepository(manager);
			this.todasPersonas = personaRepository.todas();
		} finally{
			manager.close();
		}
	}
	
	public void guardar(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
				
		try{
			trx.begin();
			
			RegistroMovimientos registro = 
					new RegistroMovimientos(new MovimientosRepository(manager));
			registro.guardar(this.movimiento);
			
			
			this.movimiento = new Movimiento();
			context.addMessage(null, new FacesMessage("Movimiento guardado con exito"));
			
			trx.commit();
		}catch(NegocioException ex){
			trx.rollback();
			FacesMessage mensaje = new FacesMessage(ex.getMessage());
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensaje);
		}
		finally{
			manager.close();
		}
		
		
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public List<Persona> getTodasPersonas() {
		return todasPersonas;
	}

	public void setTodasPersonas(List<Persona> todasPersonas) {
		this.todasPersonas = todasPersonas;
	}
	
	
	
	
	public TipoMovimiento[] getTiposMovimientos() { return TipoMovimiento.values();
	}
	
	
	
	
	
	
	
}
