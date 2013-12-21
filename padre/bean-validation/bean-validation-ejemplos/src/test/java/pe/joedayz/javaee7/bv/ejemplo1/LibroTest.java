package pe.joedayz.javaee7.bv.ejemplo1;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibroTest {

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

	    Libro01 book = new Libro01("H2G2", 12.5f, 
	    		"Best IT Scifi Book", "1234-4566-9876", 
	    		247, false);

	    Set<ConstraintViolation<Libro01>> violations = 
	    		validator.validate(book);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCausePriceLow() {

	    Libro01 book = new Libro01("H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

	    Set<ConstraintViolation<Libro01>> violations = validator.validate(book);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() {

	    Libro01 book = new Libro01();

	    Set<ConstraintViolation<Libro01>> violations = validator.validate(book);
	    displayContraintViolations(violations);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseValidatingOnlyTitle() {

	    Libro01 book = new Libro01();

	    Set<ConstraintViolation<Libro01>> violations = validator.validateProperty(book, "titulo");
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCheckingTheTitleValue() {

	    Set<ConstraintViolation<Libro01>> violations = 
	    		validator.validateValue(Libro01.class, "titulo", null);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  private void displayContraintViolations(
			  Set<ConstraintViolation<Libro01>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.
	    		  getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() +
	              " - Invalid Value = " + 
	              constraintViolation.getInvalidValue() 
	              + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
