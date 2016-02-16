package mx.emite.sdk.proxy.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class TimbrarRequest{

	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * @param usuario Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull private String usuario;
	@NotNull private String contrasena;
	
	private String sucursal;
	@NotNull private String xml;
	

	
	
	
	
	
	

	 
	
}
