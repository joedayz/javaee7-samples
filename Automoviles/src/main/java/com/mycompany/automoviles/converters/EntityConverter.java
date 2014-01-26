/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.converters;

import com.mycompany.automoviles.persistence.JPAUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author josediaz
 */

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	private Logger logger = LoggerFactory.getLogger(EntityConverter.class);
	
	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
		if(object == null) return null;
		
		try {
			Class<?> classe = object.getClass();
			Long id = (Long) classe.getMethod("getId").invoke(object);
			
			return classe.getName() + "-" + id;
		} catch (Exception e) {
			logger.error("Erro ao converter entidade em String", e);
			return null;
		}
		
	}
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
		if(string == null || string.isEmpty()) return null;
		
		try {
			String[] values = string.split("-");
			return JPAUtil.getEntityManager().find(Class.forName(values[0]), Long.valueOf(values[1]));
		} catch (Exception e) {
			logger.error("Erro ao converter String em entidade", e);
			return null;
		}
	}


}