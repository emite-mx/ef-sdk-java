package mx.emite.sdk.cfdi32.validadores;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.UuidLista;

public class UuidListaValidador implements ConstraintValidator<UuidLista, Iterable<String>>{

	@Override
	public void initialize(UuidLista anotacion) {
	}

	
	@Override
	public boolean isValid(Iterable<String> value, ConstraintValidatorContext context) {
	    if (value == null) {
	      return true;
	    }
	    for(String v:value){
	        try {
	        	UUID.fromString(v);
	        } 
	        catch (Exception ex) {
	        return false;
	        }
	    }
	    return true;
	}

	
}
