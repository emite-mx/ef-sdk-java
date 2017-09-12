package mx.emite.sdk.cfdi32.validadores;

import java.text.MessageFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import mx.emite.sdk.cfdi32.anotaciones.Clabe;
import mx.emite.sdk.enums.sat.Bancos;

public class ClabeValidador  implements ConstraintValidator<Clabe, String>{

	@Override
	public void initialize(Clabe constraintAnnotation) {
			
	}

	private final static int[] factores = {3,7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7};
	
	@Override
	public boolean isValid(String clabe, ConstraintValidatorContext context) {
		if(clabe == null) return true;
		if(clabe.length()!=18)
			return error(context,MessageFormat.format("La CLABE {0} debe de tener 18 caractéres",clabe));
		if(!StringUtils.isNumeric(clabe))
			return error(context,MessageFormat.format("La CLABE {0} debe de tener 18 dígitos",clabe));
		final String banco = clabe.substring(0, 3);
		if(Bancos.id(banco)==null)
			return error(context,MessageFormat.format("El Banco {0} de la CLABE es inválido",banco));
		final Integer checksum = Integer.parseInt(clabe.substring(17));
		int suma=0;
		for(int x=0;x<17;x++)
			suma+=(factores[x]*Character.getNumericValue(clabe.charAt(x)))%10;
		final int dv = 10 - (suma%10) == 10 ? 0 : 10 - (suma%10);
		if(!checksum.equals(dv))
			return error(context,MessageFormat.format("El Dígito verificador {0} de la CLABE es inválido (debería ser {1})",checksum,dv)) ;
		return true;
	}

	public boolean error(ConstraintValidatorContext context,final String error) {
		context.disableDefaultConstraintViolation();
        context
            .buildConstraintViolationWithTemplate(error)
            .addConstraintViolation();
        return false;
	}

	
}
