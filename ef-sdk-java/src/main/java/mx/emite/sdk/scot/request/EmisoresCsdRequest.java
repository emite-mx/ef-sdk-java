package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class EmisoresCsdRequest  {

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
	 * @param cer Archivo .cer del CSD codificado en Base64
	 */
	@NotNull 
	private String cer;
	
	/**
	 * @param key Archivo .key del CSD codificado en Base64
	 */
	@NotEmpty 
	private String key;
	
	/**
	 * @param contrasenaCsd Contraseña del archivo .key del CSD
	 */
	@NotNull 
	private String contrasenaCsd;
	
		 
	
}
