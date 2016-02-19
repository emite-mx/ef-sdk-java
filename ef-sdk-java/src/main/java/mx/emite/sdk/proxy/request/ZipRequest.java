package mx.emite.sdk.proxy.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.extra.ConsultaFiltro;
import mx.emite.sdk.utils.Utilerias;

@ToString
@Getter
public class ZipRequest{


	/**
	 * Usuario del <b>Emisor</b> 
	 * -- SETTER --
	 * @param usuario Usuario del <b>Emisor</b> obtenido de Scot&copy;
	 * 
	 */
	@NotNull private String usuario;
	@NotNull private String contrasena;
	
	@NotNull
	private Boolean xml;
	
	@NotNull
	private Boolean pdf;
	
	@NotNull
	private Boolean acuses;
	
	@Valid @NotNull
	private ConsultaFiltro filtro;
	
	
	
	public ZipRequest() {
		super();
	}


	public static ZipRequestBuilder builder() {
		return new ZipRequestBuilder();
	}

	public static class ZipRequestBuilder {
		private String usuario;
		private String contrasena;
		private Boolean xml=true;
		private Boolean pdf=false;
		private Boolean acuses=false;
		private ConsultaFiltro filtro;
		

		
		
		public ZipRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public ZipRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		/**
		 * @param xml si se desea incluir el XML
		 * 
		 */
		public ZipRequestBuilder xml(Boolean xml) {
			this.xml=xml;
			return this;
		}
		/**
		 * @param pdf si se desea incluir el PDF
		 * 
		 */
		public ZipRequestBuilder pdf(Boolean pdf) {
			this.pdf=pdf;
			return this;
		}
		/**
		 * @param acuses si se desea incluir el XML y PDF de acuse de cancelación
		 * 
		 */
		public ZipRequestBuilder acuses(Boolean acuses) {
			this.acuses=acuses;
			return this;
		}
		/**
		 * @param filtro de la consulta
		 * 
		 */
		public ZipRequestBuilder filtro(ConsultaFiltro filtro) {
			this.filtro=filtro;
			return this;
		}
		

		public ZipRequest build() throws ApiException {
			return new ZipRequest(this);
		}

		
	}

	private ZipRequest(ZipRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.xml=builder.xml;
		this.pdf=builder.pdf;
		this.acuses=builder.acuses;
		this.filtro=builder.filtro;
		Utilerias.valida(this);
	}
	
	

	 
	
}
