package mx.emite.sdk.proxy.request;

import java.io.InputStream;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
public class ValidadorRequest {

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

	
	
	public ValidadorRequest() {
		super();
	}

	public static ValidadorRequestBuilder builder() {
		return new ValidadorRequestBuilder();
	}

	public static class ValidadorRequestBuilder {
		private String usuario;
		private String contrasena;
		private String sucursal;
		private String xml;

		public ValidadorRequestBuilder codifica(final String xmlSinCodificar) throws ApiException{
			this.xml = Utilerias.codifica64Utf8(Utilerias.quitaBom(xmlSinCodificar));
			return this;
		}
		
		public ValidadorRequestBuilder archivo(final String rutaArchivoSinCodificar) throws ApiException {
			  
			return codifica(Utilerias.leeArchivo(rutaArchivoSinCodificar));
		}
		
		public ValidadorRequestBuilder is(InputStream is) throws ApiException{
			return codifica(Utilerias.leeArchivo(is));
		}
		
		public ValidadorRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public ValidadorRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public ValidadorRequestBuilder sucursal(String sucursal) {
			this.sucursal = sucursal;
			return this;
		}

		public ValidadorRequestBuilder xml(String xml) {
			this.xml = xml;
			return this;
		}

		public ValidadorRequest build() throws ApiException {
			return new ValidadorRequest(this);
		}

		
	}

	private ValidadorRequest(ValidadorRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.sucursal = builder.sucursal;
		this.xml = builder.xml;
		Utilerias.valida(this);
	}
	
	
	
	
	

	 
	
}
