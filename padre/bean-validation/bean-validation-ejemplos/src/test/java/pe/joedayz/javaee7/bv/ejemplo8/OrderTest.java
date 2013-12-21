package pe.joedayz.javaee7.bv.ejemplo8;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@Ignore
public class OrderTest {

	 // ======================================
	  // =             Attributes             =
	  // ======================================

	  protected static ValidatorFactory vf;
	  protected static Validator validator;

	  private static Date creationDate;
	  private static Date paymentDate;
	  private static Date deliveryDate;


	  // ======================================
	  // =          Lifecycle Methods         =
	  // ======================================

	  @BeforeClass
	  public static void init() throws ParseException {
	    vf = Validation.buildDefaultValidatorFactory();
	    validator = vf.getValidator();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");

	    creationDate = dateFormat.parse("01/01/2010");
	    paymentDate = dateFormat.parse("02/01/2010");
	    deliveryDate = dateFormat.parse("03/01/2010");
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
	    order.setId(1234L);
	    order.setTotalAmount(1234.5);

	    order.setCreationDate(creationDate);

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Creation.class);
	    assertEquals(0, violations.size());

	    order.setPaymentDate(paymentDate);

	    violations = validator.validate(order, Payment.class);
	    assertEquals(0, violations.size());

	    order.setDeliveryDate(deliveryDate);

	    violations = validator.validate(order, Delivery.class);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseCreationDateIsThenSetToNull() {

	    Order order = new Order();
	    order.setId(1234L);
	    order.setTotalAmount(1234.5);

	    order.setCreationDate(creationDate);

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Creation.class);
	    assertEquals(0, violations.size());

	    order.setPaymentDate(paymentDate);

	    violations = validator.validate(order, Payment.class);
	    assertEquals(0, violations.size());

	    order.setCreationDate(null);
	    order.setDeliveryDate(deliveryDate);

	    violations = validator.validate(order, Delivery.class);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseCreationDatePaymentDateAreThenSetToNull() {

	    Order order = new Order();
	    order.setId(1234L);
	    order.setTotalAmount(1234.5);

	    order.setCreationDate(creationDate);

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Creation.class);
	    assertEquals(0, violations.size());

	    order.setPaymentDate(paymentDate);

	    violations = validator.validate(order, Payment.class);
	    assertEquals(0, violations.size());

	    order.setCreationDate(null);
	    order.setPaymentDate(null);
	    order.setDeliveryDate(deliveryDate);

	    violations = validator.validate(order, Delivery.class);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDateAreNull() {

	    Order order = new Order();

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Creation.class);
	    displayContraintViolations(violations);
	    assertEquals(3, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateAreNull() {

	    Order order = new Order();

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Default.class, Creation.class, Payment.class);
	    displayContraintViolations(violations);
	    assertEquals(4, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateDeliveryDateAreNull() {

	    Order order = new Order();

	    Set<ConstraintViolation<Order>> violations = validator.validate(order, Default.class, Creation.class, Payment.class, Delivery.class);
	    displayContraintViolations(violations);
	    assertEquals(5, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Order>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
