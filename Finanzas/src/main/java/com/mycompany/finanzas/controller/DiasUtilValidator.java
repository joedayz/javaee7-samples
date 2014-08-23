package com.mycompany.finanzas.controller;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("diaUtil")
public class DiasUtilValidator  implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Date fecha = (Date) value;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		if(diaSemana < Calendar.MONDAY || diaSemana > Calendar.FRIDAY) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Fecha Invalida", 
					"La fecha debe caer en un dia útil."
					));
		}
	}

	
}
