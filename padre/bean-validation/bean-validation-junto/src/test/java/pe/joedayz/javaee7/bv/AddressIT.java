package pe.joedayz.javaee7.bv;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class AddressIT {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseConstraintViolationCauseInvalidZipCode() {

    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();

    Address address = new Address("233 Spring Street", "New York", "NY", "DummyZip", "USA");

    Set<ConstraintViolation<Address>> violations = validator.validate(address);
    assertEquals(1, violations.size());

    vf.close();
  }
}