package pe.joedayz.javaee7.bv.ejemplo4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TarjetaValidatorTest {

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
	  public void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

	    TarjetaCredito creditCard = new TarjetaCredito("12341234", "10/10", 1234, "VISA");
	    TarjetaValidator cardValidator = new TarjetaValidator();

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = TarjetaValidator.class.getMethod("validate", TarjetaCredito.class);
	    Set<ConstraintViolation<TarjetaValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
	    assertEquals(0, violations.size());

	    violations = methodValidator.validateReturnValue(cardValidator, method, Boolean.TRUE);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCauseCreditCardIsNull() throws NoSuchMethodException {

	    TarjetaValidator cardValidator = new TarjetaValidator();

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = TarjetaValidator.class.getMethod("validate", TarjetaCredito.class);
	    Set<ConstraintViolation<TarjetaValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{null});
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCauseCreditCardParametersAreNull() throws NoSuchMethodException {

	    TarjetaCredito creditCard = new TarjetaCredito(null, null, null, null);
	    TarjetaValidator cardValidator = new TarjetaValidator();

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = TarjetaValidator.class.getMethod("validate", TarjetaCredito.class);
	    Set<ConstraintViolation<TarjetaValidator>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
	    displayContraintViolations(violations);
	    assertEquals(3, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<TarjetaValidator>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
	
}
