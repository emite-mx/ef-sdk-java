package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.MetodoPago;
import mx.emite.sdk.enums.sat.MetodosPago;

public class MetodoPagoValidador extends CatalogoSatValidador<MetodoPago, String>{

	@Override
	public void initialize(MetodoPago anotacion) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return valida(value,context,MetodosPago.ids());
	}


	


	
}
