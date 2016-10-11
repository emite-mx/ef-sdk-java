package mx.emite.sdk.cfdi32.anotaciones;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;


@Documented
@Constraint(validatedBy = { })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
@Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|- |:|;|>|=|&lt;|@|_|,|\\{|\\}|`|~|&#225;|&#233;|&#237;|&#243;|&#250;|&#19 3;|&#201;|&#205;|&#211;|&#218;|&#252;|&#220;){1,20}$")
public @interface RegistroPatronal {
	
	
	String message() default "El valor no es un Registro Patronal correcto";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	boolean botones() default true;
	
	
	
}
