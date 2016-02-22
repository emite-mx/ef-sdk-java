package mx.emite.sdk.ef.request;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import mx.emite.sdk.enums.TipoCobros;
import mx.emite.sdk.enums.TipoFacturas;

@Data
@Builder
public class FacturaEmiteRequest {

	private String tokenEmite;
	
	/**
	 * @param  usuario Usuario WS del INTEGRADOR
	 */
	@NotNull
	private String usuario;

	/**
	 * @param  contrasena Contraseña WS del INTEGRADOR
	 */
	@NotNull
	private String contrasena;	
	
	/**
	 * @param  tipoFactura Tipo de Factura
	 */
	@NotNull
	private TipoFacturas tipoFactura;
	
	/**
	 * @param tipoCobro Tipo de Cobro
	 */
	@NotNull
	private TipoCobros tipoCobro;
	
	/**
	 * @param rfc Rfc del Emisor al que se le hara la factura
	 */
	@NotNull
	private String rfc;	
	
	/**
	 * @param sucursal Sucursal del Emisor al que se le hara la factura
	 */
	private String sucursal;	
	
	/**
	 * @param claveConcepto Clave de concepto a facturar
	 */
	@NotNull
	private String claveConcepto;
	
	/**
	 * @param concepto Concepto a facturar
	 */
	@NotNull
	private String concepto;
	
	/**
	 * @param montosiniva 
	 */
	@NotNull @Digits(integer = 10, fraction = 2)
	private BigDecimal montosiniva;	
	
	
	
	
	
	

	 
	
}
