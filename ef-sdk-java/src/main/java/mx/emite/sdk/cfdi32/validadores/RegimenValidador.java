package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.Regimen;
import mx.emite.sdk.enums.sat.RegimenesFiscales;

public class RegimenValidador extends CatalogoSatValidador<Regimen, Integer>{

	@Override
	public void initialize(Regimen anotacion) {
	}

	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
	    return valida(value,context,RegimenesFiscales.ids());
	}


	


	
}
