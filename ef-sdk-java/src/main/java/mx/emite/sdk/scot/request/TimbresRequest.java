package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimbresRequest  {

	
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
	

	 
	
}
