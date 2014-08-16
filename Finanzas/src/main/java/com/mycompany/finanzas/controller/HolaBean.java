package com.mycompany.finanzas.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HolaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7760475140221345549L;
	
	private String nombre;
	private String apellido;
	private String nombreCompleto;
	
	public void decirHola(){
		this.nombreCompleto = this.nombre.toUpperCase() + 
				" " + this.apellido.toUpperCase();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	

}
