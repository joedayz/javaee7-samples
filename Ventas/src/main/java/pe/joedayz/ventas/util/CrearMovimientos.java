package pe.joedayz.ventas.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pe.joedayz.ventas.model.Movimiento;
import pe.joedayz.ventas.model.Persona;
import pe.joedayz.ventas.model.TipoMovimiento;

public class CrearMovimientos {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Calendar fechaVencimiento1 = Calendar.getInstance();
		fechaVencimiento1.set(2013,  10, 1, 0, 0, 0);
		
		Calendar fechaVencimiento2 = Calendar.getInstance();
		fechaVencimiento2.set(2013,  12, 10, 0, 0, 0);
		
		Persona cliente = new Persona();
		cliente.setNombre("INVERSIONES OCHOA");
		Persona proveedor = new Persona();
		proveedor.setNombre("ACEROS AREQUIPA");
		
		Movimiento movimiento1 = new Movimiento();
		movimiento1.setDescripcion("Compra de Barras de Acero");
		movimiento1.setPersona(cliente);
		movimiento1.setFechaVencimiento(fechaVencimiento1.getTime());
		movimiento1.setFechaPago(fechaVencimiento1.getTime());
		movimiento1.setValor(new BigDecimal(103_000));
		movimiento1.setTipo(TipoMovimiento.COMPRAS);
		
		Movimiento movimiento2 = new Movimiento();
		movimiento2.setDescripcion("Compra de planchas de acero");
		movimiento2.setPersona(cliente);
		movimiento2.setFechaVencimiento(fechaVencimiento1.getTime());
		movimiento2.setFechaPago(fechaVencimiento1.getTime());
		movimiento2.setValor(new BigDecimal(15_000));
		movimiento2.setTipo(TipoMovimiento.COMPRAS);		
		
		Movimiento movimiento3 = new Movimiento();
		movimiento3.setDescripcion("Venta de planchas de acero");
		movimiento3.setPersona(proveedor);
		movimiento3.setFechaVencimiento(fechaVencimiento2.getTime());
		movimiento3.setFechaPago(fechaVencimiento2.getTime());
		movimiento3.setValor(new BigDecimal(68_000));
		movimiento3.setTipo(TipoMovimiento.VENTAS);			
		
		manager.persist(cliente);
		manager.persist(proveedor);
		manager.persist(movimiento1);
		manager.persist(movimiento2);
		manager.persist(movimiento3);
		
		tx.commit();
		manager.close();
		
	}

}
