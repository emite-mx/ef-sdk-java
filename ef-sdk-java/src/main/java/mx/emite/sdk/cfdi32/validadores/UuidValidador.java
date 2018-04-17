package mx.emite.sdk.cfdi32.validadores;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.Uuid;

public class UuidValidador implements ConstraintValidator<Uuid, String>{

	private final static String patronNumOperacion="(\\d){3}-(\\d){2}-(\\d){9}";
	
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
	    	if(value.matches(patronNumOperacion))
	    		return true;
	        return false;
	    }
	}
	
	/*public static void main(String[] argsa) {
		String rfc="B4DE8283-746A-4D93-837F-9C093365A8C1";
		System.out.println(new UuidValidador().isValid(rfc, nullt));
		
	}*/

	
}
