/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author josediaz
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();
    private static EntityManagerFactory factory;

    private JPAUtil() {
    }

    public static EntityManager getEntityManager() {
        if (JPAUtil.factory == null) {
            JPAUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        EntityManager m = JPAUtil.manager.get();
        if (m == null) {
            m = JPAUtil.factory.createEntityManager();
            JPAUtil.manager.set(m);
        }
        return m;
    }

    public static void evictCache(EntityManager em, String region) {
        ((Session) em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
    }

    public static void closeEntityManager() {
        EntityManager m = JPAUtil.manager.get();
        if (m != null) {
            EntityTransaction t = m.getTransaction();
            if (t.isActive()) { // TODO
                // CoreLog.getInstance()
                // .getLog()
                // .warn("EntityManager contains an active transaction, commiting transaction");
                // t.commit();
            }
            m.flush();
            m.close();
            JPAUtil.manager.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        JPAUtil.factory.close();
    }
}
