package mx.emite.sdk.proxy.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.ToString;
import mx.emite.sdk.enums.sat.cfdi33.TiposDeComprobante33;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.serializers.TiposDeComprobante33Serializer;
import mx.emite.sdk.utils.Utilerias;

@Getter
@ToString
public class ConfirmacionRequest {

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
	
	
	@JsonSerialize(using=TiposDeComprobante33Serializer.class)
	private TiposDeComprobante33 tipo;
	private String correo;
	private String rfcReceptor;
	private BigDecimal tc;
	private BigDecimal total;
	
	
	public static ConfirmacionRequestBuilder builder() {
		return new ConfirmacionRequestBuilder();
	}

	public static class ConfirmacionRequestBuilder {
		private String usuario;
		private String contrasena;
		private String sucursal;
		private TiposDeComprobante33 tipo;
		private String correo;
		private String rfcReceptor;
		private BigDecimal tc;
		private BigDecimal total;
		
		
		
		public ConfirmacionRequestBuilder usuario(String usuario) {
			this.usuario = usuario;
			return this;
		}

		public ConfirmacionRequestBuilder contrasena(String contrasena) {
			this.contrasena = contrasena;
			return this;
		}

		public ConfirmacionRequestBuilder sucursal(String sucursal) {
			this.sucursal = sucursal;
			return this;
		}
		
		public ConfirmacionRequestBuilder tipo(TiposDeComprobante33 tipo) {
			this.tipo=tipo;
			return this;
		}

		public ConfirmacionRequestBuilder correo(String correo) {
			this.correo=correo;
			return this;
		}
		
		public ConfirmacionRequestBuilder rfcReceptor(String rfcReceptor) {
			this.rfcReceptor=rfcReceptor;
			return this;
		}
		
		public ConfirmacionRequestBuilder tc(BigDecimal tc) {
			this.tc=tc;
			return this;
		}
		
		public ConfirmacionRequestBuilder total(BigDecimal total) {
			this.total=total;
			return this;
		}
		
		

		public ConfirmacionRequest build() throws ApiException {
			return new ConfirmacionRequest(this);
		}

		

		
	}

	private ConfirmacionRequest(ConfirmacionRequestBuilder builder) throws ApiException {
		this.usuario = builder.usuario;
		this.contrasena = builder.contrasena;
		this.sucursal=builder.sucursal;
		this.tipo=builder.tipo;
		this.correo=builder.correo;
		this.rfcReceptor=builder.rfcReceptor;
		this.tc=builder.tc;
		this.total=builder.total;
		Utilerias.valida(this);
	}
	
	
	
	
	

	 
	
}
