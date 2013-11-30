package pe.joedayz.javaee7.cdi.ejemplo27;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Transactional
@Interceptors(ProfileInterceptor27.class)
public class CustomerService27 {

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

  public void createCustomer(Customer27 customer) {
    em.persist(customer);
  }

  public Customer27 findCustomerById(Long id) {
    return em.find(Customer27.class, id);
  }
}