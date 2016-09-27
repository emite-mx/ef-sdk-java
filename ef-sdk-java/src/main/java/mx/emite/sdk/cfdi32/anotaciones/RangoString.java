package mx.emite.sdk.cfdi32.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mx.emite.sdk.cfdi32.validadores.RangoStringValidador;


@Constraint(validatedBy = {RangoStringValidador.class})
@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RangoString {

	String message() default "rango1 y rango2 deben de estar presentes";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
