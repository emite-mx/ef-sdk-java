package mx.emite.sdk.cfdi32.validadores;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.Uuid;

public class UuidValidador implements ConstraintValidator<Uuid, String>{

	@Override
	public void initialize(Uuid anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    if (value == null) {
	      return true;
	    }
	    try {
	        UUID.fromString(value);
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

	
}
