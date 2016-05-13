package mx.emite.sdk.proxy.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.extra.CamposNombreArchivo;
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
	
	@NotNull
	private List<CamposNombreArchivo> folder;
	@NotNull
	private List<CamposNombreArchivo> archivo;
	
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
		private List<CamposNombreArchivo> folder;
		private List<CamposNombreArchivo> archivo;
		
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
		 * @return builder
		 */
		public ZipRequestBuilder xml(Boolean xml) {
			this.xml=xml;
			return this;
		}
		/**
		 * @param pdf si se desea incluir el PDF
		 * @return builder
		 */
		public ZipRequestBuilder pdf(Boolean pdf) {
			this.pdf=pdf;
			return this;
		}
		/**
		 * @param acuses si se desea incluir el XML y PDF de acuse de cancelación
		 * @return builder
		 */
		public ZipRequestBuilder acuses(Boolean acuses) {
			this.acuses=acuses;
			return this;
		}
		/**
		 * @param filtro de la consulta
		 * @return builder
		 */
		public ZipRequestBuilder filtro(ConsultaFiltro filtro) {
			this.filtro=filtro;
			return this;
		}
		
		/**
		 * @param nombre del folder
		 * @return builder
		 */
		public ZipRequestBuilder folder(CamposNombreArchivo nombre) {
			if(this.folder==null)
				this.folder=new ArrayList<>();
			this.folder.add(nombre);
			return this;
		}
		
		/**
		 * @param nombre del folder
		 * @return builder
		 */
		public ZipRequestBuilder folders(List<CamposNombreArchivo> nombre) {
			if(this.folder==null)
				this.folder=nombre;
			else
				this.folder.addAll(nombre);
			return this;
		}
		
		/**
		 * @param nombre del archivo
		 * @return builder
		 */
		public ZipRequestBuilder archivo(CamposNombreArchivo nombre) {
			if(this.archivo==null)
				this.archivo=new ArrayList<>();
			this.archivo.add(nombre);
			return this;
		}
		
		/**
		 * @param nombre del archivo
		 * @return builder
		 */
		public ZipRequestBuilder archivos(List<CamposNombreArchivo> nombre) {
			if(this.archivo==null)
				this.archivo=nombre;
			else
				this.archivo.addAll(nombre);
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
		this.folder=builder.folder;
		this.archivo=builder.archivo;
		Utilerias.valida(this);
	}
	
	

	 
	
}
