package pe.joedayz.javaee7.bv.ejemplo14;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class BookTest {

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

	    Book book = new Book("H2G2", 12.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCausePriceLow() {

	    Book book = new Book("H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() {

	    Book book = new Book();

	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    displayContraintViolations(violations);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseValidatingOnlyTitle() {

	    Book book = new Book();

	    Set<ConstraintViolation<Book>> violations = validator.validateProperty(book, "title");
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCheckingTheTitleValue() {

	    Set<ConstraintViolation<Book>> violations = validator.validateValue(Book.class, "title", null);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Book>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
