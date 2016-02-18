package mx.emite.sdk.errores;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties(value={"cause"})
public class ApiException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7552430730864319330L;
	
	
	private final I_Api_Errores error;
	
	
	private List<String> mensajes = new ArrayList<String>();
	
	@JsonIgnore
	private final Exception excepcion;
	
	public ApiException(I_Api_Errores error) {
		super(error.getDescripcion());
		this.error=error;
		this.excepcion=null;	
	}
	
	public ApiException(I_Api_Errores error, Exception ex) {
		super(error.getDescripcion(),ex);
		this.error=error;
		this.excepcion=ex;		
	}

	public ApiException(I_Api_Errores error,String mensaje, Exception ex) {
		super(error.getDescripcion(),ex);
		this.error=error;
		this.excepcion=ex;	
		mensajes.add(mensaje);
	}
	
	public ApiException(I_Api_Errores error, String mensaje) {
		this(error);
		mensajes.add(mensaje);		
	}
	
	
	

	public ApiException(I_Api_Errores tipo, List<String> errores) {
		this(tipo);
		mensajes.addAll(errores);
	}

	/*private void procesaErrores(BindingResult result) {
		List<FieldError> fieldErrors = result.getFieldErrors();
		List<ObjectError> globalErrors = result.getGlobalErrors();
		fieldErrors.stream().forEach(i->mensajes.add(String.join(":", i.getField(),i.getDefaultMessage())));
		globalErrors.stream().forEach(i->mensajes.add(String.join(":", i.getObjectName(),i.getDefaultMessage())));
	}*/

	public ApiException(I_Api_Errores tipo, Set<ConstraintViolation<Object>> errores) {
		this(tipo);
		errores.stream().forEach(i->mensajes.add(MessageFormat.format(i.getMessage(),i.getPropertyPath())));
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

	public Exception getExcepcion() {
		return excepcion;
	}


	

	
	
	
}
