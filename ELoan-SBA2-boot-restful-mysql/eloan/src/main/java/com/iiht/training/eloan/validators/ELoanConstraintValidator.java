package com.iiht.training.eloan.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ELoanConstraintValidator implements ConstraintValidator<ELoanValidator, String> {

	private String expectedPrefix;

	@Override
	public void initialize(ELoanValidator constraintAnnotation) {

		this.expectedPrefix = constraintAnnotation.prefix();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
