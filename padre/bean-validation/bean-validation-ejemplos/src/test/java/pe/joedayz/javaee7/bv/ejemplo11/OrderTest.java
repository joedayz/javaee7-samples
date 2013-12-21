package pe.joedayz.javaee7.bv.ejemplo11;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class OrderTest {


	  // ======================================
	  // =             Attributes             =
	  // ======================================

	  protected static ValidatorFactory vf;
	  protected static Validator validator;


	  // ======================================
	  // =          Lifecycle Methods         =
	  // ======================================

	  @BeforeClass
	  public static void init() throws ParseException {
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
	  public void shouldRaiseNoConstraintsViolation() {

	    Order order = new Order();
	    order.setOrderId("CA45678");

	    Set<ConstraintViolation<Order>> violations = validator.validate(order);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseRegex() {

	    Order order = new Order();
	    order.setOrderId("FA45678");

	    Set<ConstraintViolation<Order>> violations = validator.validate(order);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
