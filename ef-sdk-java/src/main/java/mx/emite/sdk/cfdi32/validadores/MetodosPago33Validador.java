package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.MetodosPago33;

public class MetodosPago33Validador extends CatalogoSatValidador<MetodosPago33, String>{

	@Override
	public void initialize(MetodosPago33 anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return valida(value,context,mx.emite.sdk.enums.sat.cfdi33.MetodosPago33.ids());
	}


	


	
}
