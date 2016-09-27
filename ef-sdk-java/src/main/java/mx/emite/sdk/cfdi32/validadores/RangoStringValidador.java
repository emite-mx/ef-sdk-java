package mx.emite.sdk.cfdi32.validadores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import mx.emite.sdk.cfdi32.anotaciones.RangoString;
import mx.emite.sdk.cfdi32.validadores.interfaces.TieneRangoString;

public class RangoStringValidador implements ConstraintValidator<RangoString, TieneRangoString> {

	final static DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd/MM/yyyy",new Locale("es","MX"));
	
	@Override
	public void initialize(RangoString constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(TieneRangoString value, ConstraintValidatorContext context) {
		if(StringUtils.isEmpty(value.getRango1())||StringUtils.isEmpty(value.getRango2())){
			context.disableDefaultConstraintViolation();
	        context
	            .buildConstraintViolationWithTemplate("rango1 y rango2 deben estar llenos")
	            .addConstraintViolation();
	        return false;
		}
		try{
			final LocalDate rango1 = LocalDate.parse(value.getRango1(),df);
			final LocalDate rango2 = LocalDate.parse(value.getRango2(),df);
			if(rango1.isAfter(rango2)){
				context.disableDefaultConstraintViolation();
		        context
		            .buildConstraintViolationWithTemplate("el rango2 debe de ser posterior al rango1")
		            .addConstraintViolation();
		        return false;
			}
				
		}
		catch(DateTimeParseException ex){
			context.disableDefaultConstraintViolation();
	        context
	            .buildConstraintViolationWithTemplate("las fechas deben de estar en formato DD/MM/YYYY")
	            .addConstraintViolation();
	        return false;
		}
		return true;
	}

}
