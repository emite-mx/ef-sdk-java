package mx.emite.sdk.cfdi32.validadores;

import java.lang.annotation.Annotation;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class CatalogoSatValidador<T extends Annotation,E> implements ConstraintValidator<T,E>{

	
	
	@Override
	public void initialize(T anotacion) {
	
	}

	@Override
	public abstract boolean isValid(E value, ConstraintValidatorContext context);
	
	
	protected boolean valida(E value,ConstraintValidatorContext context, List<E> values) {
		if(value==null)
			return true;
		for(E s:values){
			if(s.equals(value))
				return true;
		}
		final MessageFormat mf = new MessageFormat(context.getDefaultConstraintMessageTemplate());
		
		context.disableDefaultConstraintViolation();
        context
            .buildConstraintViolationWithTemplate(mf.format(new Object[]{value.toString(),Arrays.toString(values.toArray())}))
            .addConstraintViolation();
        return false;
		
	}
	
}
