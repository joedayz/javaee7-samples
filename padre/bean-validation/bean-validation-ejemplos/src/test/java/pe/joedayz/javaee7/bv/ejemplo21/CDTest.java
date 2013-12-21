package pe.joedayz.javaee7.bv.ejemplo21;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CDTest {
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

	    CD cd = new CD("Kind of Blue", 12.5f);

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCauseTitleAndPriceAreNull() {

	    CD cd = new CD();

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
	    displayContraintViolations(violations);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty() {

	    CD cd = new CD();
	    cd.setNumberOfCDs(2);

	    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");
	    assertEquals(0, violations.size());
	  }

	  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
	  public void shouldRaiseConstraintViolationValidatingNumberOfCDsProperty() {

	    CD cd = new CD();
	    cd.setNumberOfCDs(7);

	    Set<ConstraintViolation<CD>> violations = validator.validateProperty(cd, "numberOfCDs");
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("must be less than or equal to 5", violations.iterator().next().getMessage());
	    assertEquals(7, violations.iterator().next().getInvalidValue());
	    assertEquals("{javax.validation.constraints.Max.message}", violations.iterator().next().getMessageTemplate());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue() {

	    Set<ConstraintViolation<CD>> violations = validator.validateValue(CD.class, "numberOfCDs", 2);
	    displayContraintViolations(violations);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationValidatingNumberOfCDsPropertyValue() {

	    Set<ConstraintViolation<CD>> violations = validator.validateValue(CD.class, "numberOfCDs", 7);
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseNoMethodParameterConstraintViolation() throws NoSuchMethodException {

	    CD cd = new CD("Kind of Blue", 12.5f);

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = CD.class.getMethod("calculatePrice", Float.class);
	    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(2.2)});
	    assertEquals(0, violations.size());
	  }

	  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
	  public void shouldRaiseMethodParameterConstraintViolationCauseRateIsLow() throws NoSuchMethodException {

	    CD cd = new CD("Kind of Blue", 12.5f);

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Method method = CD.class.getMethod("calculatePrice", Float.class);
	    Set<ConstraintViolation<CD>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(1.2)});
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	    assertEquals("must be greater than or equal to 1.4", violations.iterator().next().getMessage());
	    assertEquals(new Float(1.2), violations.iterator().next().getInvalidValue());
	    assertEquals("{javax.validation.constraints.DecimalMin.message}", violations.iterator().next().getMessageTemplate());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationWithGroup() {

	    CD cd = new CD("Kind of Blue", 12.5f);
	    cd.setDescription("Best Jazz CD ever");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, PrintingCatalog.class);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseNoConstraintViolationWithGroupEvenWithNullTitleAndPrice() {

	    CD cd = new CD();
	    cd.setDescription("Best Jazz CD ever");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, PrintingCatalog.class);
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitleAndPrice() {

	    CD cd = new CD();
	    cd.setDescription("Best Jazz CD ever");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class, PrintingCatalog.class);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithNoGroupsCauseNullTitleAndPrice() {

	    CD cd = new CD();
	    cd.setDescription("Best Jazz CD ever");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithDefaultGroupCauseNullTitleAndPrice() {

	    CD cd = new CD();
	    cd.setDescription("Best Jazz CD ever");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class);
	    assertEquals(2, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitlePriceAndSize() {

	    CD cd = new CD();
	    cd.setDescription("Jazz");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, Default.class, PrintingCatalog.class);
	    assertEquals(3, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithOneGroupCauseSize() {

	    CD cd = new CD();
	    cd.setDescription("Too short");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, PrintingCatalog.class);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationWithGroupCauseSizeIsShort() {

	    CD cd = new CD("Kind of Blue", 12.5f);
	    cd.setDescription("Jazz");

	    Set<ConstraintViolation<CD>> violations = validator.validate(cd, PrintingCatalog.class);
	    assertEquals(1, violations.size());
	  }


	  private void displayContraintViolations(Set<ConstraintViolation<CD>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
