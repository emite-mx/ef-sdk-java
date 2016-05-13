package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class SucursalesNombreRequest  {


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
	 * @param nombreAnterior de la sucursal
	 */
	@NotEmpty
	private String nombreAnterior;
	
	/**
	 * @param nombreNuevo que reemplazará al anterior
	 */
	@NotEmpty
	private String nombreNuevo;
	
	

	

	 
	
}
