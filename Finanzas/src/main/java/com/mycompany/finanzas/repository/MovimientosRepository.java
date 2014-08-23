package com.mycompany.finanzas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mycompany.finanzas.modelo.Movimiento;
import com.mycompany.finanzas.util.JpaUtil;

public class MovimientosRepository {

	private EntityManager manager;
	
	public MovimientosRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Movimiento> todos(){
 		EntityManager manager = JpaUtil.getEntityManager();
 		TypedQuery<Movimiento> query = manager.createQuery("from Movimiento",
 				Movimiento.class);
 		return query.getResultList();
	}

	
}
