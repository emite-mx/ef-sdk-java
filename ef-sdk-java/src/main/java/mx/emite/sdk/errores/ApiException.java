package mx.emite.sdk.errores;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.emite.sdk.serializers.ApiExceptionDeserializer;

//@JsonIgnoreProperties(value={"cause"})
@JsonDeserialize(using=ApiExceptionDeserializer.class)
public class ApiException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7552430730864319330L;
	
	
	private I_Api_Errores error;
	
	
	private List<String> mensajes = new ArrayList<String>();
	
	@JsonIgnore
	private Throwable excepcion;
	
	@Deprecated
	public ApiException(){
		
	}
	
	public ApiException(I_Api_Errores error) {
		super(error.getDescripcion());
		this.error=error;
		this.excepcion=null;	
	}
	
	public ApiException(I_Api_Errores error, Throwable ex) {
		super(error.getDescripcion(),ex);
		if(ex instanceof ConstraintViolationException)
			this.mensajes.addAll(sacaError(((ConstraintViolationException)ex)));
		this.error=error;
		this.excepcion=ex;		
	}

	private List<String>  sacaError(ConstraintViolationException ce) {
		final List<String> res = new ArrayList<>();
		ce.getConstraintViolations().stream().forEach(i->
			res.add(i.getPropertyPath() + "\t "+ MessageFormat.format(i.getMessage(),i.getPropertyPath()))
		);
		return res;
	}

	public ApiException(I_Api_Errores error,String mensaje, Throwable ex) {
		super(error.getDescripcion(),ex);
		this.error=error;
		this.excepcion=ex;	
		mensajes.add(mensaje);
	}
	
	public ApiException(I_Api_Errores error, String mensaje) {
		this(error);
		mensajes.add(mensaje);		
	}
	
	public ApiException(I_Api_Errores error,BindingResult result) {
		this(error);
		procesaErrores(result);
		
	}
	
	

	

	public ApiException(I_Api_Errores tipo, List<String> errores) {
		this(tipo);
		mensajes.addAll(errores);
	}

	private void procesaErrores(BindingResult result) {
		List<FieldError> fieldErrors = result.getFieldErrors();
		List<ObjectError> globalErrors = result.getGlobalErrors();
		fieldErrors.stream().forEach(i->mensajes.add(String.join(":", i.getField(),i.getDefaultMessage())));
		globalErrors.stream().forEach(i->mensajes.add(String.join(":", i.getObjectName(),i.getDefaultMessage())));
	}

	public <T> ApiException(I_Api_Errores tipo, Set<ConstraintViolation<T>> errores) {
		this(tipo);
		errores.stream().forEach(i->
				mensajes.add(i.getPropertyPath() + "\t"+ MessageFormat.format(i.getMessage(),i.getPropertyPath()))
		);
	}

	public String getTraza() {
		return excepcion==null?this.error.name(): ExceptionUtils.getStackTrace(this);
	}


	public I_Api_Errores getError() {
		return error;
	}

	public List<String> getErrores() {
		return mensajes;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}

	public Throwable getExcepcion() {
		return excepcion;
	}

	/**
	 * @return todos los mensajes de error en un solo String
	 */
	public String getMensajesLista(){
		return Arrays.toString(mensajes.toArray());
	}

	@Override
	public String getMessage() {
		return (error==null?"":"EMITE["+error.getId()+"]: ")+ super.getMessage()+(mensajes==null?"":"\n"+getMensajesLista());
	}

	
	public String getMensajeCompleto() {
		return (error==null?"":"EMITE["+error.getId()+"]: ")+ super.getMessage()+(mensajes==null?"":"\n"+getMensajesLista());
	}

	@Override
	@Deprecated
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

	

	

	
	
	
}
