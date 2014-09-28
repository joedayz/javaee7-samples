package pe.joedayz.ventas.service;

import java.util.Date;

import javax.inject.Inject;

import pe.joedayz.ventas.model.Movimiento;
import pe.joedayz.ventas.repository.MovimientoRepository;
import pe.joedayz.ventas.util.Transactional;


public class RegistroMovimientos {

	@Inject
	private MovimientoRepository movimientoRepository;
	

	
	
	@Transactional
	public void guardar(Movimiento movimiento) throws NegocioException{
		if(movimiento.getFechaPago() !=null &&
				movimiento.getFechaPago().after(new Date())){
			throw new NegocioException("Fecha de pago no puede ser una fecha futura");
		}
		
		this.movimientoRepository.guardar(movimiento);
		
	}
	
	@Transactional
	public void eliminar(Movimiento movimiento) throws NegocioException{
		movimiento = this.movimientoRepository.porId(movimiento.getId());
		
		if(movimiento.getFechaPago()!=null){
			throw new NegocioException("No es posible eliminar un movimiento pagado");
		}
		this.movimientoRepository.eliminar(movimiento);
	}

}
