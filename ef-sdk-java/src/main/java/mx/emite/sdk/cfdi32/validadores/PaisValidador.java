package mx.emite.sdk.cfdi32.validadores;

import javax.validation.ConstraintValidatorContext;

import mx.emite.sdk.cfdi32.anotaciones.Pais;
import mx.emite.sdk.enums.sat.Paises;

public class PaisValidador  extends CatalogoSatValidador<Pais, String>{


	@Override
	public void initialize(Pais anotacion) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    return valida(value,context,Paises.ids());
	}
	
}
