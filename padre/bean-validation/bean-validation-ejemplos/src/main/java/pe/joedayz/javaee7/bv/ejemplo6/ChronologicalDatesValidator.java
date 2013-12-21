package pe.joedayz.javaee7.bv.ejemplo6;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChronologicalDatesValidator implements
		ConstraintValidator<ChronologicalDates, Order> {

	@Override
	public void initialize(ChronologicalDates constraintAnnotation) {
	}

	@Override
	public boolean isValid(Order order, 
			ConstraintValidatorContext context) {
		return order.getCreationDate().getTime() <
				order.getPaymentDate()
				.getTime()
				&& order.getPaymentDate().getTime() < 
				order.getDeliveryDate()
						.getTime();
	}
}