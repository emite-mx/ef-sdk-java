package mx.emite.sdk.proxy.request;

import java.io.InputStream;
import java.nio.file.Path;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.Comprobante;
import mx.emite.sdk.cfdi32.nomina11.ComprobanteNomina11;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
public class SellarYTimbrarTxt33Request {

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

	@NotNull
	private String txt;

	

	
	
	public static SellarYTimbrarRequest33Builder builder() {
		return new SellarYTimbrarRequest33Builder();
	}

	public static class SellarYTimbrarRequest33Builder {
		private String usuario;
		private String contrasena;
		private String txt;

		public SellarYTimbrarRequest33Builder codifica(final String xmlSinCodificar) throws ApiException{
			this.txt = Utilerias.codifica64Utf8(xmlSinCodificar);
			return this;
		}
		
		public SellarYTimbrarRequest33Builder archivo(final String rutaArchivoSinCodificar) throws ApiException {
			  
			return codifica(Utilerias.leeArchivo(rutaArchivoSinCodificar));
		}
		
		public SellarYTimbrarRequest33Builder archivo(final Path rutaArchivoSinCodificar) throws ApiException {
			return codifica(Utilerias.leeArchivo(rutaArchivoSinCodificar));
		}
		
		public SellarYTimbrarRequest33Builder is(InputStream is) throws ApiException{
			return codifica(Utilerias.leeArchivo(is));
		}
		
		public SellarYTimbrarRequest33Builder comprobante(Comprobante comprobante) throws ApiException{
			return codifica(Utilerias.marshallcfdi32(comprobante));
		}
		
		public SellarYTimbrarRequest33Builder comprobante(ComprobanteNomina11 comprobante) throws ApiException{
			return codifica(Utilerias.marshallnom32(comprobante));
		}
		
		public SellarYTimbrarRequest33Builder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public SellarYTimbrarRequest33Builder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

	

		public SellarYTimbrarRequest33Builder txt(String txt) {
			this.txt = txt;
			return this;
		}

		public SellarYTimbrarTxt33Request build() throws ApiException {
			return new SellarYTimbrarTxt33Request(this);
		}

		

		
	}

	private SellarYTimbrarTxt33Request(SellarYTimbrarRequest33Builder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.txt = builder.txt;
		Utilerias.valida(this);
	}

}
