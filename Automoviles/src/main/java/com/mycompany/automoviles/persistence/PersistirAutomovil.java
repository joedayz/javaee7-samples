/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.persistence;

import com.mycompany.automoviles.entidades.Automovil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

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
            //System.out.println(a.getModeloId().getMarcaId().getNombre());

            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(auto);
            tx.commit();
        }


    }
}
