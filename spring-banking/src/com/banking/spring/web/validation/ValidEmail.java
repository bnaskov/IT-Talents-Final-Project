package com.banking.spring.web.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = com.banking.spring.web.validation.ValidEmailImpl.class)
public @interface ValidEmail {

	String message() default "This does not appear to be a valid email address";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 5;
}

/*
 * @Target({ElementType.FIELD, ElementType.METHOD})
 * 
 * @Retention(RetentionPolicy.RUNTIME)
 * 
 * @Constraint(validatedBy = {})
 * 
 * @Pattern(regexp = Constants.PATTERN, flags = Pattern.Flag.CASE_INSENSITIVE)
 * public @interface EmailWithTld { String message() default "Wrong email";
 * Class<?>[] groups() default { }; Class<? extends Payload>[] payload() default
 * { }; }
 * 
 * interface Constants { static final String ATOM =
 * "[a-z0-9!#$%&'*+/=?^_`{|}~-]"; static final String DOMAIN = "(" + ATOM +
 * "+(\\." + ATOM + "+)+"; static final String IP_DOMAIN =
 * "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
 * 
 * static final String PATTERN = "^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN +
 * "|" + IP_DOMAIN + ")$"; }
 */