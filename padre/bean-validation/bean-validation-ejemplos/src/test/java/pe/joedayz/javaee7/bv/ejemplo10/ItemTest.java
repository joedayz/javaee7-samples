package pe.joedayz.javaee7.bv.ejemplo10;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ItemTest {

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
	    Item book = new Item("H2G2", 12.5f, "Best IT Scifi Book");

	    // Validate the cd
	    Set<ConstraintViolation<Item>> violations = validator.validate(book);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolation() {

	    // Creates a book
	    Item book = new Item();

	    // Validate the cd
	    Set<ConstraintViolation<Item>> violations = validator.validate(book);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationOnCalculateVAT() throws NoSuchMethodException {

	    Item item = new Item("H2G2", 12.5f, "Best IT Scifi Book");

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = Item.class.getMethod("calculateVAT");
	    Set<ConstraintViolation<Item>> violations = methodValidator.validateReturnValue(item, method, new Float(10.0));
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationOnCalculatePrice() throws NoSuchMethodException {

	    Item item = new Item("H2G2", 12.5f, "Best IT Scifi Book");

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = Item.class.getMethod("calculatePrice", Float.class);
	    Set<ConstraintViolation<Item>> violations = methodValidator.validateParameters(item, method, new Object[]{new Float(4.5)});
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationOnCalculatePriceCauseRateIsTooLow() throws NoSuchMethodException {

	    Item item = new Item("H2G2", 12.5f, "Best IT Scifi Book");

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = Item.class.getMethod("calculatePrice", Float.class);
	    Set<ConstraintViolation<Item>> violations = methodValidator.validateParameters(item, method, new Object[]{new Float(0.5)});
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Item>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	          "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
