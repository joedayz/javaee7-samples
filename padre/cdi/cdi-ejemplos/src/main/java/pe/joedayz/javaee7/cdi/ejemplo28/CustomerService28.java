package pe.joedayz.javaee7.cdi.ejemplo28;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Transactional
@Interceptors({I1.class, I2.class})
public class CustomerService28 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  public void init() {
    // ...
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void createCustomer(Customer28 customer) {
    em.persist(customer);
  }

  @Interceptors({I3.class, I4.class})
  public Customer28 findCustomerById(Long id) {
    return em.find(Customer28.class, id);
  }
}