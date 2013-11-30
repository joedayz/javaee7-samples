package pe.joedayz.javaee7.cdi.ejemplo21;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import java.io.Serializable;


@ConversationScoped
public class CustomerCreatorWizard21 implements Serializable {

  private Login login;
  private Account account;

  @Inject
  private CustomerService customerService;

  @Inject
  private Conversation conversation;

  public void saveLogin() {
    conversation.begin();

    login = new Login();
    // Set login properties
  }

  public void saveAccount() {
    account = new Account();
    // Set account properties
  }

  public void createCustomer() {
    Customer customer = new Customer();
    customer.setLogin(login);
    customer.setAccount(account);
    customerService.createCustomer(customer);

    conversation.end();
  }
}
