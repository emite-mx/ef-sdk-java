package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.Estado;
import mx.emite.sdk.enums.sat.Estados;

public class EstadoValidador  extends CatalogoSatValidador<Estado, String>{


	@Override
	public void initialize(Estado anotacion) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return valida(value,context,Estados.ids());
	}
	
}
