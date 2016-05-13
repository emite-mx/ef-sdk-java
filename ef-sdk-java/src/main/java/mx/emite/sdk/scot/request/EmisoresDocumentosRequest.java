package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.utils.Utilerias;

@Data
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
	
	public static EmisoresDocumentosBuilder builder(){
		return new EmisoresDocumentosBuilder();
	}
	

	public static class EmisoresDocumentosBuilder {
	private String token;
	private String rfc;
	private Integer idTipoDocumento;
	private String pdf;
	public EmisoresDocumentosBuilder token(String token) {
	this.token=token;
	return this;
	}
	public EmisoresDocumentosBuilder rfc(String rfc) {
	this.rfc=rfc;
	return this;
	}
	public EmisoresDocumentosBuilder idTipoDocumento(Integer idTipoDocumento) {
	this.idTipoDocumento=idTipoDocumento;
	return this;
	}
	/**
	 * @param pdf documento binario codificado en base 64
	 * @return this builder
	 */
	public EmisoresDocumentosBuilder pdf(String pdf) {
	this.pdf=pdf;
	return this;
	}
	/**
	 * @param pdf documento binario sin codificar
	 * @return this builder
	 */
	public EmisoresDocumentosBuilder pdf(byte[] pdf) {
		this.pdf=Utilerias.codifica64Binario(pdf);
		return this;
	}
	public EmisoresDocumentosRequest build(){
	return new EmisoresDocumentosRequest(this);
	}
	}
	private EmisoresDocumentosRequest(EmisoresDocumentosBuilder builder){
	this.token=builder.token;
	this.rfc=builder.rfc;
	this.idTipoDocumento=builder.idTipoDocumento;
	this.pdf=builder.pdf;
	}
}
