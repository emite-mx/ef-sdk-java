package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.constraintvalidators.EmailValidator;

import mx.emite.sdk.cfdi32.anotaciones.CorreoListaString;

public class CorreoListaStringValidator implements ConstraintValidator<CorreoListaString, String>{

	final EmailValidator validador = new EmailValidator();
	
	@Override
	public void initialize(CorreoListaString anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    if (value == null) {
	      return true;
	    }
	    
	    final String[] lista = value.split(",");
	    for(String v:lista){
	    	if(StringUtils.isEmpty(v))
	    		return false;
	    	
	        if(!validador.isValid(v.trim(), context)){
	        	context.disableDefaultConstraintViolation();
		        context
		            .buildConstraintViolationWithTemplate(v +" no es una dirección de correo válida")
		            .addConstraintViolation();
		        return false;
	        }
	        	
	    }
	    return true;
	}

	
}
