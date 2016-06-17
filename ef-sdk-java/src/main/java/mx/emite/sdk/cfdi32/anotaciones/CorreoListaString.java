package mx.emite.sdk.cfdi32.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mx.emite.sdk.cfdi32.validadores.CorreoListaStringValidator;

@Constraint(validatedBy = {CorreoListaStringValidator.class})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CorreoListaString {

	String message() default "{0} debe contener direcciones de correo válidos";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
