package mx.emite.sdk.ef.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.TipoTimbres;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class TokenConsumoRequest {

	private String tokenEmite;
	
	/**
	 * @param  usuario Usuario WS del INTEGRADOR
	 */
	@NotNull
	private String usuario;

	/**
	 * @param  contrasena Contraseña WS del INTEGRADOR
	 */
	@NotNull
	private String contrasena;	
	
	/**
	 * @param sucursal Sucursal del Emisor al que se le hara la factura
	 */
	private String sucursal;	
	
	
	/**
	 * @param  tipoTimbre Tipo de Timbre
	 */
	@NotNull
	private TipoTimbres tipoTimbre;
	
	/**
	 * @param noTimbres Número de timbres a consumir 
	 */
	@NotNull
	private Integer noTimbres;	
	
	
	 
	
}
