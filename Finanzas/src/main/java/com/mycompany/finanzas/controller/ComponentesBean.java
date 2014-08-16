package com.mycompany.finanzas.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ComponentesBean {

	private String equipoFavorito;
	private String[] equiposFavoritos;
	
	private Integer[] programaciones;
	
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
