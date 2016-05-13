package mx.emite.sdk.proxy.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.anotaciones.Uuid;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
public class XmlRequest {

	
	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * @param usuario Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull private String usuario;
	@NotNull private String contrasena;
	
	@NotNull @Uuid
	private String uuid;
	
	
	public static XmlRequestBuilder builder() {
		return new XmlRequestBuilder();
	}

	public static class XmlRequestBuilder {
		private String usuario;
		private String contrasena;
		private String uuid;
		

		
		
		public XmlRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public XmlRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public XmlRequestBuilder uuid(String uuid) {
			this.uuid=uuid;
			return this;
		}

		

		public XmlRequest build() throws ApiException {
			return new XmlRequest(this);
		}

		
	}

	private XmlRequest(XmlRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.uuid = builder.uuid;
		Utilerias.valida(this);
	}
	

	 
	
}
