package pe.joedayz.ventas.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class MiBean {

	private String nombre;
	private int cantidadDeCaracteres;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void transformar(AjaxBehaviorEvent event){
		this.nombre = this.nombre.toUpperCase();
		this.cantidadDeCaracteres = this.nombre.length();
	}

	public int getCantidadDeCaracteres() {
		return cantidadDeCaracteres;
	}

	public void setCantidadDeCaracteres(int cantidadDeCaracteres) {
		this.cantidadDeCaracteres = cantidadDeCaracteres;
	}
	
	
	
}
