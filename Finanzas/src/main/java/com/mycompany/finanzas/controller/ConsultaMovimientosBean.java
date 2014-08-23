package com.mycompany.finanzas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.mycompany.finanzas.modelo.Movimiento;
import com.mycompany.finanzas.repository.MovimientosRepository;
import com.mycompany.finanzas.util.JpaUtil;


@ManagedBean
@ViewScoped
public class ConsultaMovimientosBean {

 	private List<Movimiento> movimientos;
 	
 	public void consultar(){
 		EntityManager manager = JpaUtil.getEntityManager();
 		
 		MovimientosRepository movimientoRepository = new MovimientosRepository(manager);
 		this.movimientos = movimientoRepository.todos();
 		
 		manager.close();
 	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
 	
 	
}

