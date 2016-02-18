package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.FormaPago;

public class FormaPagoValidador implements ConstraintValidator<FormaPago, String>{

	@Override
	public void initialize(FormaPago anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    if (value == null) {
	      return true;
	    }
	    if (value.equalsIgnoreCase("pago en una sola exhibición")|| value.equalsIgnoreCase("pago en una sola exhibicion")) {
	      return true;
	    }
	    if(value.equalsIgnoreCase("pago en parcialidades")) {
		      return true;
		}
	    return false;
	}

	
}
