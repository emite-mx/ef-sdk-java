package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class EmisoresRequest  {

	/**
	 * Token del <b>Integrador</b> obtenido con el servicio de Token 
	 * -- SETTER --
	 * 
	 * @param token
	 *            Token del <b>Integrador</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String token;
	
	
	/**
	 * @param rfc del emisor, si se deja en blanco se consultan todos los emisores	
	 */
	@Rfc
	private String rfc;

	
	
	
	

	 
	
}
