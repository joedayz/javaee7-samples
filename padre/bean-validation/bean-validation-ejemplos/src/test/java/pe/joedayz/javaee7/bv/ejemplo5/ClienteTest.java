package pe.joedayz.javaee7.bv.ejemplo5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

	 // ======================================
	  // =             Attributes             =
	  // ======================================

	  protected static ValidatorFactory vf;
	  protected static Validator validator;

	  // ======================================
	  // =          Lifecycle Methods         =
	  // ======================================

	  @BeforeClass
	  public static void init() {
	    vf = Validation.buildDefaultValidatorFactory();
	    validator = vf.getValidator();
	  }

	  @AfterClass
	  public static void close() {
	    vf.close();
	  }

	  // ======================================
	  // =              Methods               =
	  // ======================================

	  @Test
	  public void shouldRaiseNoConstraintViolation() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "jsmith@gmail.com", "recovery@gmail.com", "1234565", new Date(), new Date());


	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseTooShort() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "a@b.c", "recovery@gmail.com", "1234565", new Date(), new Date());


	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseEmailWithoutDot() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "jsmith@gmailcom", "recovery@gmail.com", "1234565", new Date(), new Date());


	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseEmailWithoutAt() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "jsmithgmail.com", "recovery@gmail.com", "1234565", new Date(), new Date());

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseEmailsAndFirstnameAreNull() {

	    // Creates a book
	    Cliente customer = new Cliente();

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(3, violations.size());
	  }

	  @Test
	  public void shouldCheckEmailDefaultMessage() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "dummy", "recovery@gmail.com", "1234565", new Date(), new Date());

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("Email address doesn't look good", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldCheckEmailCustomMessage() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "jsmith@gmail.com", "dummy", "1234565", new Date(), new Date());

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("Recovery email is not a valid email address", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldCheckAgeMessage() {

	    // Creates a book
	    Cliente customer = new Cliente("John", "Smith", "jsmith@gmail.com", "recovery@gmail.com", "1234565", new Date(), new Date());
	    customer.setAge(10);

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("Customer is too young. Should be older that 18", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldCheckFirstnameMessage() {

	    // Creates a book
	    Cliente customer = new Cliente("J", "Smith", "jsmith@gmail.com", "recovery@gmail.com", "1234565", new Date(), new Date());

	    // Validate the cd
	    Set<ConstraintViolation<Cliente>> violations = validator.validate(customer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("Firstname should be between 4 and 50", violations.iterator().next().getMessage());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Cliente>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
