package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class EmisoresEstatusRequest {

	
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
	@NotNull
	private String rfc;
	
	
	/**
	 * @param documentacion Si se requiere consultar tambien el estatus de documentación	
	 */
	@NotNull
	private Boolean documentacion;
	
	 
	/**
	 * @param cuentasporpagar Si se requiere consultar tambien el estatus de cuentas por pagar	
	 */
	@NotNull
	private Boolean cuentasporpagar;
	
		 
	
}
