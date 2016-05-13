package mx.emite.sdk.proxy.request;

import java.io.InputStream;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.nomina.ComprobanteNomina;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
public class SellarYTimbrarTxtRequest {

	/**
	 * Usuario del <b>Emisor</b> -- SETTER --
	 * 
	 * @param usuario
	 *            Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String usuario;
	@NotNull
	private String contrasena;

	private String sucursal;
	@NotNull
	private String txt;

	

	
	
	public static SellarYTimbrarRequestBuilder builder() {
		return new SellarYTimbrarRequestBuilder();
	}

	public static class SellarYTimbrarRequestBuilder {
		private String usuario;
		private String contrasena;
		private String sucursal;
		private String txt;

		public SellarYTimbrarRequestBuilder codifica(final String xmlSinCodificar) throws ApiException{
			this.txt = Utilerias.codifica64Utf8(xmlSinCodificar);
			return this;
		}
		
		public SellarYTimbrarRequestBuilder archivo(final String rutaArchivoSinCodificar) throws ApiException {
			  
			return codifica(Utilerias.leeArchivo(rutaArchivoSinCodificar));
		}
		
		public SellarYTimbrarRequestBuilder is(InputStream is) throws ApiException{
			return codifica(Utilerias.leeArchivo(is));
		}
		
		public SellarYTimbrarRequestBuilder comprobante(Comprobante comprobante) throws ApiException{
			return codifica(Utilerias.marshallcfdi32(comprobante));
		}
		
		public SellarYTimbrarRequestBuilder comprobante(ComprobanteNomina comprobante) throws ApiException{
			return codifica(Utilerias.marshallnom32(comprobante));
		}
		
		public SellarYTimbrarRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public SellarYTimbrarRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public SellarYTimbrarRequestBuilder sucursal(String sucursal) {
			this.sucursal = sucursal;
			return this;
		}

		public SellarYTimbrarRequestBuilder txt(String txt) {
			this.txt = txt;
			return this;
		}

		public SellarYTimbrarTxtRequest build() throws ApiException {
			return new SellarYTimbrarTxtRequest(this);
		}

		

		
	}

	private SellarYTimbrarTxtRequest(SellarYTimbrarRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.sucursal = builder.sucursal;
		this.txt = builder.txt;
		Utilerias.valida(this);
	}

}
