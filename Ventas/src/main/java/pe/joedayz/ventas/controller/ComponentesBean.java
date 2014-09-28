package pe.joedayz.ventas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ComponentesBean {

	private String equipoFavorito;
	private String[] equiposFavoritos;
	
	private Integer[] programaciones;
	
	
	public void registrar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage mensaje = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Registro efectuado", 
				"Cliente Jose registrado con exito" );
		context.addMessage(null, mensaje);
		
	}
	
	
	public String getEquipoFavorito() {
		return equipoFavorito;
	}

	public void setEquipoFavorito(String equipoFavorito) {
		this.equipoFavorito = equipoFavorito;
	}

	public String[] getEquiposFavoritos() {
		return equiposFavoritos;
	}

	public void setEquiposFavoritos(String[] equiposFavoritos) {
		this.equiposFavoritos = equiposFavoritos;
	}

	public Integer[] getProgramaciones() {
		return programaciones;
	}

	public void setProgramaciones(Integer[] programaciones) {
		this.programaciones = programaciones;
	}
	

	
}
