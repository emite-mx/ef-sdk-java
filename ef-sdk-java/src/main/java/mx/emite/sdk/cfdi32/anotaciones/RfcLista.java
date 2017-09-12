package mx.emite.sdk.cfdi32.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mx.emite.sdk.cfdi32.validadores.RfcListaValidador;

@Constraint(validatedBy = {RfcListaValidador.class})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RfcLista {

	String message() default "{0} debe contener rfcs válidos";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
