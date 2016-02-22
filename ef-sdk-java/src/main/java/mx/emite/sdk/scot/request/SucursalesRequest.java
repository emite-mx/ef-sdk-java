package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class SucursalesRequest {

	
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
	 * @param rfc del emisor	
	 */
	@NotNull @Rfc
	private String rfc;
	

	 
	
}
