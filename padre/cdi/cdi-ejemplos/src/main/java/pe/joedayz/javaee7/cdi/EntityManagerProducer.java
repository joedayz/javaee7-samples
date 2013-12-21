package pe.joedayz.javaee7.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cdiPU");

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Produces
  private EntityManager createEntityManager() {
    EntityManager em = entityManagerFactory.createEntityManager();
    return em;
  }

  private void closeEntityManager(@Disposes 
		  	EntityManager entityManager) {
    if (entityManager.isOpen()) {
      entityManager.close();
    }
  }
}