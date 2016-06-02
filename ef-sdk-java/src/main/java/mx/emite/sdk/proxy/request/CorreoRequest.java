package mx.emite.sdk.proxy.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.anotaciones.Uuid;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.extra.CorreoParametros;
import mx.emite.sdk.proxy.request.extra.PdfParametros;
import mx.emite.sdk.utils.Utilerias;

@Getter
@ToString

public class CorreoRequest  {

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
	

	/**
	 * Parámetros del envio
	 */
	@Valid @NotNull
	private CorreoParametros correo;

	/**
	 * Si esta variable es verdadera el servicio enviará el correo y adicionalmente regresara el XML y el PDF en Base 64
	 */
	@NotNull
	private Boolean recuperarArchivos;

		
	
	public static CorreoRequestBuilder builder() {
		return new CorreoRequestBuilder();
	}

	public static class CorreoRequestBuilder {
		private String usuario;
		private String contrasena;
		private String plantilla;
		private String uuid;
		private List<PdfParametros> parametros = new ArrayList<>();
		private Boolean recuperarArchivos=false;
		private CorreoParametros correo;
		
		
		public CorreoRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public CorreoRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public CorreoRequestBuilder plantilla(String plantilla) {
			this.plantilla = plantilla;
			return this;
		}

		public CorreoRequestBuilder uuid(String uuid) {
			this.uuid = uuid;
			return this;
		}
		
		public CorreoRequestBuilder recuperarArchivos(Boolean recuperarArchivos) {
			this.recuperarArchivos=recuperarArchivos;
			return this;
		}
		
		public CorreoRequestBuilder correo(CorreoParametros correo) {
			this.correo=correo;
			return this;
		}
		
		public CorreoRequestBuilder parametros(List<PdfParametros> parametros) {
			this.parametros.addAll(parametros);
			return this;
		}
		public CorreoRequestBuilder parametro(PdfParametros parametro) {
			this.parametros.add(parametro);
			return this;
		}
		
		

		public CorreoRequest build() throws ApiException {
			return new CorreoRequest(this);
		}

		

		
	}

	private CorreoRequest(CorreoRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.plantilla=builder.plantilla;
		this.uuid=builder.uuid;
		this.parametros=builder.parametros;
		this.recuperarArchivos=builder.recuperarArchivos;
		this.correo=builder.correo;
		Utilerias.valida(this);
	}
	
	
	
	
	
	

	 
	
}
