package pe.joedayz.javaee7.bv.ejemplo13;

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

public class ItemServerConnectionTest {

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

	    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

	    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

	    ItemServerConnection itemServer = new ItemServerConnection("dummy", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

	    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("dummy", violations.iterator().next().getInvalidValue());
	    assertEquals("Malformed URL", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseInvalidProtocol() {

	    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "ftp://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

	    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("ftp://www.cdbookstore.com/book/1334", violations.iterator().next().getInvalidValue());
	    assertEquals("Invalid protocol", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseInvalidHost() {

	    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.dummy.com/book/1334", "ftp://www.cdbookstore.com:21");

	    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("http://www.dummy.com/book/1334", violations.iterator().next().getInvalidValue());
	    assertEquals("Invalid host", violations.iterator().next().getMessage());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseInvalidPort() {

	    ItemServerConnection itemServer = new ItemServerConnection("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:22");

	    Set<ConstraintViolation<ItemServerConnection>> violations = validator.validate(itemServer);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("ftp://www.cdbookstore.com:22", violations.iterator().next().getInvalidValue());
	    assertEquals("Invalid port", violations.iterator().next().getMessage());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<ItemServerConnection>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
