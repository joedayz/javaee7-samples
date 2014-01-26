/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automovilesoracle.persistence;


import com.mycompany.automovilesoracle.entidades.Automovil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author josediaz
 */
public class PersistirAutomovil {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Query q = em.createQuery("select a from Automovil a", Automovil.class);

        List<Automovil> autos = q.getResultList();

        for (Automovil auto : autos) {
            System.out.println(auto.getModelo().getMarca().getNombre());

            //EntityTransaction tx = em.getTransaction();
            //tx.begin();
            //em.remove(auto);
            //tx.commit();
        }


    }
}
