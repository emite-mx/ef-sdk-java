package mx.emite.sdk.proxy.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.anotaciones.Uuid;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.extra.PdfParametros;
import mx.emite.sdk.utils.Utilerias;

@Getter
@ToString
public class PdfRequest {

	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * 
	 * @param usuario
	 *            Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull
	private String usuario;
	@NotNull
	private String contrasena;

	
	/**
	 * Nombre de la plantilla (previamente desarrollada por parte de Emite), si se deja en blanco se usa el formato genérico
	 */
	private String plantilla;
	
	@NotNull @Uuid
	private String uuid;
	
	/**
	 * Parámetros adicionales proporcionados por emite
	 */
	@Valid
	private List<PdfParametros> parametros;

	
	
	public static PdfRequestBuilder builder() {
		return new PdfRequestBuilder();
	}

	public static class PdfRequestBuilder {
		private String usuario;
		private String contrasena;
		private String plantilla;
		private String uuid;
		private List<PdfParametros> parametros = new ArrayList<>();
		
		
		
		public PdfRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public PdfRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public PdfRequestBuilder plantilla(String plantilla) {
			this.plantilla = plantilla;
			return this;
		}

		public PdfRequestBuilder uuid(String uuid) {
			this.uuid = uuid;
			return this;
		}
		
		
		public PdfRequestBuilder parametros(List<PdfParametros> parametros) {
			this.parametros.addAll(parametros);
			return this;
		}
		public PdfRequestBuilder parametro(PdfParametros parametro) {
			this.parametros.add(parametro);
			return this;
		}
		
		

		public PdfRequest build() throws ApiException {
			return new PdfRequest(this);
		}

		

		
	}

	private PdfRequest(PdfRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.plantilla=builder.plantilla;
		this.uuid=builder.uuid;
		this.parametros=builder.parametros;
		Utilerias.valida(this);
	}
	
	
	
	
	

	 
	
}
