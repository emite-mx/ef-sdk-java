package mx.emite.sdk.proxy.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.cfdi32.anotaciones.UuidLista;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.utils.Utilerias;

@Getter
@ToString
public class CancelarRequest {

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

	private String sucursal;
	
	/**
	 * Archivo Pfx del <b>Emisor</b> codificado en Base 64 
	 * -- SETTER --
	 * 
	 * @param pfx codificado en Base64, si el CSD ha sido cargado en Scot no es necesario mandar este parametro
	 * 
	 */
	private String pfx;

	private String contrasenaPfx;
	
	@NotNull @UuidLista
	private List<String> uuids;
	
	

	public static CancelarRequestBuilder builder() {
		return new CancelarRequestBuilder();
	}

	public static class CancelarRequestBuilder {
		private String usuario;
		private String contrasena;
		private String sucursal;
		private String pfx;
		private String contrasenaPfx;
		private List<String> uuids = new ArrayList<>();
		
		
		
		public CancelarRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public CancelarRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public CancelarRequestBuilder sucursal(String sucursal) {
			this.sucursal = sucursal;
			return this;
		}

		public CancelarRequestBuilder pfx(String pfx) {
			this.pfx = pfx;
			return this;
		}
		
		public CancelarRequestBuilder contrasenaPfx(String contrasenaPfx) {
			this.contrasenaPfx = contrasenaPfx;
			return this;
		}
		
		public CancelarRequestBuilder uuids(List<String> uuids) {
			this.uuids.addAll(uuids);
			return this;
		}
		public CancelarRequestBuilder uuid(String uuid) {
			this.uuids.add(uuid);
			return this;
		}
		
		

		public CancelarRequest build() throws ApiException {
			return new CancelarRequest(this);
		}

		

		
	}

	private CancelarRequest(CancelarRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.sucursal = builder.sucursal;
		this.pfx=builder.pfx;
		this.contrasenaPfx=builder.contrasenaPfx;
		this.uuids=builder.uuids;
		Utilerias.valida(this);
	}
	
	

	 
	
}
