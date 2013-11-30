package pe.joedayz.javaee7.cdi.ejemplo33;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Transactional
@Loggable33
public class CustomerService33 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Auditable33
  public void createCustomer(Customer33 customer) {
    em.persist(customer);
  }

  public Customer33 findCustomerById(Long id) {
    return em.find(Customer33.class, id);
  }
}