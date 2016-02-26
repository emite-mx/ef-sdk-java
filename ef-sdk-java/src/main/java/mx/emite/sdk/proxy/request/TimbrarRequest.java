package mx.emite.sdk.proxy.request;

import java.io.InputStream;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
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
	

	public static TimbrarRequestBuilder builder() {
		return new TimbrarRequestBuilder();
	}

	public static class TimbrarRequestBuilder {
		private String usuario;
		private String contrasena;
		private String sucursal;
		private String xml;

		public TimbrarRequestBuilder codifica(final String xmlSinCodificar) throws ApiException{
			this.xml = Utilerias.codifica64Utf8(xmlSinCodificar);
			return this;
		}
		
		public TimbrarRequestBuilder archivo(final String rutaArchivoSinCodificar) throws ApiException {
			  
			return codifica(Utilerias.leeArchivo(rutaArchivoSinCodificar));
		}
		
		public TimbrarRequestBuilder is(InputStream is) throws ApiException{
			return codifica(Utilerias.leeArchivo(is));
		}
		
		public TimbrarRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public TimbrarRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public TimbrarRequestBuilder sucursal(String sucursal) {
			this.sucursal = sucursal;
			return this;
		}

		public TimbrarRequestBuilder xml(String xml) {
			this.xml = xml;
			return this;
		}

		public TimbrarRequest build() throws ApiException {
			return new TimbrarRequest(this);
		}

		
	}

	private TimbrarRequest(TimbrarRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.sucursal = builder.sucursal;
		this.xml = builder.xml;
		Utilerias.valida(this);
	}
	
	
	
	
	

	 
	
}
