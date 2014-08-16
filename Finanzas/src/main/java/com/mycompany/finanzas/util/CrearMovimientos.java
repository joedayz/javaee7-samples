package com.mycompany.finanzas.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mycompany.finanzas.modelo.Movimiento;
import com.mycompany.finanzas.modelo.Persona;
import com.mycompany.finanzas.modelo.TipoMovimiento;

public class CrearMovimientos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		//preparamos los objetos
		Calendar fechaVencimiento1 = Calendar.getInstance();
		fechaVencimiento1.set(2014, 10, 1, 0, 0, 0);

		Calendar fechaVencimiento2 = Calendar.getInstance();
		fechaVencimiento2.set(2014, 12, 1, 0, 0, 0);		
		
		Persona cliente = new Persona();
		cliente.setNombre("Juan Perez");

		Persona proveedor = new Persona();
		proveedor.setNombre("JoeDayz");
		
		Movimiento movimiento = new Movimiento();
		movimiento.setDescripcion("Taller de primefaces");
		movimiento.setPersona(cliente);
		movimiento.setFechaVencimiento(fechaVencimiento1.getTime());
		movimiento.setFechaPago(fechaVencimiento1.getTime());
		movimiento.setValor(new BigDecimal(1000));
		movimiento.setTipo(TipoMovimiento.VENTAS);
		
		//persistir
		manager.persist(cliente);
		manager.persist(proveedor);
		manager.persist(movimiento);
		
		tx.commit();
		manager.close();
	}

}
