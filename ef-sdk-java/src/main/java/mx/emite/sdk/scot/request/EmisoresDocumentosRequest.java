package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;

@Data
@Builder
public class EmisoresDocumentosRequest  {

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
	 * @param idTipoDocumento Tipo de documento a enviar de acuerdo al catalogo de documentos	
	 */
	@NotNull
	private Integer idTipoDocumento;
	
	/**
	 * @param pdf Archivo pdf del documento codificado en Base64
	 */
	@NotNull 
	private String pdf;
	
	
	
}
