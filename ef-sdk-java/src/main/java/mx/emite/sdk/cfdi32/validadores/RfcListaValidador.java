package mx.emite.sdk.cfdi32.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.RfcLista;
import mx.emite.sdk.utils.Utilerias;

public class RfcListaValidador implements ConstraintValidator<RfcLista, Iterable<String>>{

	final static Pattern patron = Pattern.compile(Utilerias.PATRON_RFC);
	
	@Override
	public void initialize(RfcLista anotacion) {
	}

	
	@Override
	public boolean isValid(Iterable<String> value, ConstraintValidatorContext context) {
	    if (value == null) {
	      return true;
	    }
	    for(String v:value){
	        	final Matcher m = patron.matcher(v);
	        if(!m.matches()) {
	        		context.disableDefaultConstraintViolation();
		        context
		            .buildConstraintViolationWithTemplate(v+" no es un rfc valido")
		            .addConstraintViolation();
		        
	        		return false;
	        }
	    }
	    return true;
	}

	
}
