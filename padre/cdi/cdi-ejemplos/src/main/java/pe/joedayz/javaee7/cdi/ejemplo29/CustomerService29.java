package pe.joedayz.javaee7.cdi.ejemplo29;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Transactional
@Loggable29
public class CustomerService29 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void createCustomer(Customer29 customer) {
    em.persist(customer);
  }

  public Customer29 findCustomerById(Long id) {
    return em.find(Customer29.class, id);
  }
}