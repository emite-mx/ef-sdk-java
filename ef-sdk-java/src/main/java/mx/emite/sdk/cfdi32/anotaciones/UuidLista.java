package mx.emite.sdk.cfdi32.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mx.emite.sdk.cfdi32.validadores.UuidListaValidador;

@Constraint(validatedBy = {UuidListaValidador.class})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface UuidLista {

	String message() default "{0} debe contener uuids válidos";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
