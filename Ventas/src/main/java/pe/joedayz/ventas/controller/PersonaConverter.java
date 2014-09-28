package pe.joedayz.ventas.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pe.joedayz.ventas.model.Persona;
import pe.joedayz.ventas.repository.PersonaRepository;
import pe.joedayz.ventas.service.CDILocator;


@FacesConverter(forClass = Persona.class)
public class PersonaConverter implements Converter{

	//@Inject
	private PersonaRepository personaRepository;
	
	public PersonaConverter(){
		this.personaRepository = CDILocator.getBean(PersonaRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Persona retorno = null;
		
		
			if(value!=null){
				
				retorno = personaRepository.porId(new Long(value));
			}
			return retorno;
		
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			return ((Persona) value).getId().toString();
		}
		return null;
	}

}
