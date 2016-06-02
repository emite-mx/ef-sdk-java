package mx.emite.sdk.proxy.request;

import javax.validation.constraints.NotNull;

import org.jsondoc.core.annotation.ApiObject;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiObject
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=false)
@Builder
public class EstatusRequest   {

	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * 
	 * @param usuario
	 *            Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String usuario;
	@NotNull
	private String contrasena;

	private Boolean documentacion;
	
	private Boolean cuentasporpagar;
	
	
	
	  
	
	
	

	 
	
}
