package mx.emite.sdk.scot.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.scot.request.extra.SucursalInfo;

@Data
@Builder
public class SucursalesModificacionRequest  {

	
	/**
	 * Token del <b>Integrador</b> obtenido con el servicio de Token 
	 * -- SETTER --
	 * 
	 * @param token
	 *            Token del <b>Integrador</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull @NotEmpty
	private String token;
	
	
	/**
	 * @param rfc del emisor	
	 */
	@Rfc @NotEmpty
	private String rfc;
	
	/**
	 * @param sucursal datos de la sucursal 
	 */
	@Valid @NotNull
	private SucursalInfo sucursal;
	
	
	
	
	 
	
}
