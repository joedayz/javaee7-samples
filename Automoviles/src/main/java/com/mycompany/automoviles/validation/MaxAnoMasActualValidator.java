/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.validation;

import java.text.MessageFormat;
import java.util.Calendar;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author josediaz
 */
public class MaxAnoMasActualValidator implements ConstraintValidator<MaxAnoMasActual, Integer> {

	private int maxValue;
	@Override
	public void initialize(MaxAnoMasActual annotation) {
		int anosAdicionais = annotation.value();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		maxValue = anoAtual + anosAdicionais;
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(!(value <= maxValue)){
			String template = context.getDefaultConstraintMessageTemplate();
			String message = MessageFormat.format(template, maxValue);
			context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		return true;
	}

}
