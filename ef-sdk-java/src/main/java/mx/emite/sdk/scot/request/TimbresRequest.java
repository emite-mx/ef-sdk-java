package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimbresRequest  {

	
	/**
	 * Usuario del <b>Integrador</b> 
	 * -- SETTER --
	 * 
	 * @param usuario
	 *            Usuario del <b>Integrador</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String usuario;
	@NotNull
	private String contrasena;
	

	 
	
}
