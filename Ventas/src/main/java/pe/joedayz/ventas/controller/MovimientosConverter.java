package pe.joedayz.ventas.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.ventas.model.Movimiento;
import pe.joedayz.ventas.repository.MovimientoRepository;
import pe.joedayz.ventas.service.CDILocator;

@FacesConverter(forClass=Movimiento.class)
public class MovimientosConverter implements Converter {

	private MovimientoRepository movimientoRepository;
	
	public MovimientosConverter(){
		this.movimientoRepository = CDILocator.getBean(MovimientoRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Movimiento retorno = null;
		if(value!=null){
			retorno = this.movimientoRepository.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Movimiento movimiento = ((Movimiento) value);
			return movimiento.getId() == null? null: movimiento.getId().toString();
		}
		return null;
	}

}
