package mx.emite.sdk.scot.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import mx.emite.sdk.cfdi32.anotaciones.Rfc;
import mx.emite.sdk.utils.Utilerias;

@Data
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
	
	public static EmisoresCsdRequestBuilder builder(){
		return new EmisoresCsdRequestBuilder();
	}
	

	public static class EmisoresCsdRequestBuilder {
	private String token;
	private String rfc;
	private String cer;
	private String key;
	private String contrasenaCsd;
	public EmisoresCsdRequestBuilder token(String token) {
	this.token=token;
	return this;
	}
	public EmisoresCsdRequestBuilder rfc(String rfc) {
	this.rfc=rfc;
	return this;
	}
	
	/**
	 * @param cer llave publica codificada en base 64
	 * @return this builder
	 */
	public EmisoresCsdRequestBuilder cer(String cer) {
	this.cer=cer;
	return this;
	}
	/**
	 * @param cer llave publica binaria
	 * @return this builder
	 */
	public EmisoresCsdRequestBuilder cer(byte[] cer) {
		this.cer=Utilerias.codifica64Binario(cer);
		return this;
	}
	/**
	 * @param cer llave privada codificada en base 64
	 * @return this builder
	 */
	public EmisoresCsdRequestBuilder key(String key) {
	this.key=key;
	return this;
	}
	/**
	 * @param cer llave privada binaria
	 * @return this builder
	 */
	public EmisoresCsdRequestBuilder key(byte[] key) {
		this.key=Utilerias.codifica64Binario(key);
		return this;
	}
	public EmisoresCsdRequestBuilder contrasenaCsd(String contrasenaCsd) {
	this.contrasenaCsd=contrasenaCsd;
	return this;
	}
	public EmisoresCsdRequest build(){
	return new EmisoresCsdRequest(this);
	}
	}
	private EmisoresCsdRequest(EmisoresCsdRequestBuilder builder){
	this.token=builder.token;
	this.rfc=builder.rfc;
	this.cer=builder.cer;
	this.key=builder.key;
	this.contrasenaCsd=builder.contrasenaCsd;
	}
}
