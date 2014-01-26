/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.controllers;

import com.mycompany.automoviles.entidades.Modelo;
import com.mycompany.automoviles.persistence.JPAUtil;
import com.mycompany.automoviles.persistence.QueryDataModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.primefaces.model.LazyDataModel;
/**
 *
 * @author josediaz
 */
@ManagedBean
@ViewScoped
public class ModeloBean {

    
	private Modelo modelo;
	private List<Modelo> modelos;

	private LazyDataModel<Modelo> lazyDataModel;

	@PostConstruct
	public void init(){
		modelo = new Modelo();
	}
	
	
	public String grabar(Modelo modelo) {
		EntityManager em = JPAUtil.getEntityManager();
		em.persist(modelo);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modelo fue grabado con exito!"));
		
		return "listar";
	}

	public LazyDataModel<Modelo> getLazyDataModel() {
		if (lazyDataModel == null) {
			String jpql = "select m from Modelo m";
			lazyDataModel = new QueryDataModel<Modelo>(jpql);
		}

		return lazyDataModel;
	}
	
	public List<Modelo> getModelos() {
		if (modelos == null) {
			modelos = JPAUtil.getEntityManager().createQuery("select m from Modelo m", Modelo.class).getResultList();
		}

		return modelos;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
    
    
}

