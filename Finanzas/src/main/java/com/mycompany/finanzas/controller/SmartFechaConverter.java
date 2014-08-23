package com.mycompany.finanzas.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("smartDate")
public class SmartFechaConverter implements Converter {

	private static final DateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		Date fechaConvertida = null;
		if (value == null || value.equals("")) {
			return null;
		}
		if ("hoy".equalsIgnoreCase(value)) {
			fechaConvertida = getFechaActual().getTime();
		} else if ("manhana".equalsIgnoreCase(value)

		|| "manhana".equalsIgnoreCase(value)) {
			Calendar amanha = getFechaActual();
			amanha.add(Calendar.DAY_OF_MONTH, 1);
			fechaConvertida = amanha.getTime();
		} else if ("anteayer".equalsIgnoreCase(value)) {
			Calendar ontem = getFechaActual();
			ontem.add(Calendar.DAY_OF_MONTH, -1);
			fechaConvertida = ontem.getTime();
		} else {
			try {
				fechaConvertida = FORMATO.parse(value);
			} catch (ParseException e) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Fecha incorreta.",
						"Ingrese una fecha correcta."));
			}
		}
		return fechaConvertida;
	}

	private Calendar getFechaActual() {
		Calendar dataAtual = new GregorianCalendar();
		dataAtual.set(Calendar.HOUR_OF_DAY, 0);
		dataAtual.set(Calendar.MINUTE, 0);
		dataAtual.set(Calendar.SECOND, 0);
		dataAtual.set(Calendar.MILLISECOND, 0);
		return dataAtual;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return FORMATO.format((Date) value);
	}

}
