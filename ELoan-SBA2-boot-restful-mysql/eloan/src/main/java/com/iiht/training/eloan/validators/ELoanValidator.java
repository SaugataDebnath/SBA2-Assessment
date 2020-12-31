package com.iiht.training.eloan.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD })

@Retention(RetentionPolicy.RUNTIME)
public @interface ELoanValidator {

	public String prefix();

	public String message();

	public Class<?>[] groups();

	public Class<? extends Payload>[] payload();

}
