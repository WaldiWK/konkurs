package pl.kuranc.demo.konkurs.controller.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ValidEmailValidator.class)
@Documented
public @interface ValidEmail {
	String message() default "Invalid email";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}

