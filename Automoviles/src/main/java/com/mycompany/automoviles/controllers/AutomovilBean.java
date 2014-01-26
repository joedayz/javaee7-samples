/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.controllers;

import com.mycompany.automoviles.entidades.Automovil;
import com.mycompany.automoviles.entidades.Marca;
import com.mycompany.automoviles.entidades.Modelo;
import com.mycompany.automoviles.persistence.JPAUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author josediaz
 */
@ManagedBean
@ViewScoped
public class AutomovilBean implements Serializable {

    static final long serialVersionUID = -8780407253943723401L;
    private Automovil automovil;
    private List<Automovil> automoviles;
    private Marca marca; // util para buscar los modelos (combo en cascada)

    @PostConstruct
    public void init() {
        automovil = new Automovil();
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public String grabar(Automovil auto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(auto);

        JPAUtil.evictCache(em, Automovil.LISTAR_DESTACADOS);

        FacesMessage msg = new FacesMessage("Automovil grabado con exito!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "listar";
    }

    public void buscarAutomoviles(Modelo modelo) {

        String jpql = "select a from Automovil a where 1=1";
        Map<String, Object> params = new HashMap<>();
        if (modelo.getMarca() != null) {
            jpql += " and a.modelo.marca = :marca";
            params.put("marca", modelo.getMarca());
        }
        if (modelo.getDescripcion()!= null && !modelo.getDescripcion().isEmpty()) {
            jpql += " and a.modelo.descripcion like :descripcion";
            params.put("descripcion", "%" + modelo.getDescripcion()+ "%");
        }

        TypedQuery<Automovil> query = JPAUtil.getEntityManager().createQuery(jpql, Automovil.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {

            query.setParameter(param.getKey(), param.getValue());
        }

        automoviles = query.getResultList();

    }

    public List<Automovil> getAutomoviles() {
        if (automoviles == null) {
            automoviles = JPAUtil.getEntityManager().
                    createNamedQuery(Automovil.LISTAR_DESTACADOS, Automovil.class).getResultList();
        }

        return automoviles;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
