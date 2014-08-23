package com.mycompany.finanzas.service;

import java.util.Date;

import com.mycompany.finanzas.exception.NegocioException;
import com.mycompany.finanzas.modelo.Movimiento;
import com.mycompany.finanzas.repository.MovimientosRepository;

public class RegistroMovimientos {

	private MovimientosRepository movimientosRepository;
	
	public RegistroMovimientos(MovimientosRepository movimientosRepository){
		this.movimientosRepository = movimientosRepository;
	}
	
	public void guardar(Movimiento movimiento) throws NegocioException {
		if(movimiento.getFechaPago() != null && 
				movimiento.getFechaPago().after(new Date())){
			throw new NegocioException("La fecha de pago no puede ser futura");
		}
		this.movimientosRepository.agregar(movimiento);
	}
	
}
