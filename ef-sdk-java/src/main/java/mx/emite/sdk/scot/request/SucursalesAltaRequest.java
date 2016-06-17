package mx.emite.sdk.scot.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.scot.request.extra.SucursalInfo;

@Data
@Builder
public class SucursalesAltaRequest {

	
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
	
	/**
	 * @param sucursales lista de sucursales a dar de alta 
	 */
	@Valid @NotEmpty @Singular("sucursal")
	private List<SucursalInfo> sucursales;
	
	
	
	/**
	 *  modificar si la sucursal ya se encuentra dado de alta
	 */
	@NotNull 
	public Boolean modificar;
	
	

	

	 
	
}
