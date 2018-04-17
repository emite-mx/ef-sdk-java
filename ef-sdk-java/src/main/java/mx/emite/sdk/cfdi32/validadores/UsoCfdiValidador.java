package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.UsoCfdi;
import mx.emite.sdk.enums.sat.cfdi33.UsosCfdi33;

public class UsoCfdiValidador extends CatalogoSatValidador<UsoCfdi, String>{

	@Override
	public void initialize(UsoCfdi anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return valida(value,context,UsosCfdi33.ids());
	}


	


	
}
