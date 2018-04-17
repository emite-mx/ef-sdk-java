package mx.emite.sdk.cfdi32.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mx.emite.sdk.cfdi32.validadores.MetodosPago33Validador;

@Constraint(validatedBy = {MetodosPago33Validador.class})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MetodosPago33 {

	String message() default "El método de pago {0} es inválido, debe de ser alguno de PUE o PPD";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	

}
