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
@Pattern(regexp = "^P(([1-9][0-9]{0,3})|0)W|P([1-9][0-9]?Y)?(([1-9]|1[012])M)?(0|[1-9]|[12][0-9]|3[01])D$")                   
                    
public @interface Antiguedad {
	
	
	String message() default "El valor no es una Antigüedad correcta";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	boolean botones() default true;
	
	
	
}
