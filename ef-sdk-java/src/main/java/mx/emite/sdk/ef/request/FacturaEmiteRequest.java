package mx.emite.sdk.ef.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.TipoCobros;
import mx.emite.sdk.enums.TipoFacturas;


@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
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
	 * @param diasVencimiento Número de dias para cálculo de vencimiento de la factura 
	 */
	@NotNull
	private Integer diasVencimiento;	
	
	
	/**
	 * @param conceptos Lista de conceptos a facturar 
	 */
	@NotEmpty @Valid @Singular
	private List<FacturaEmiteConcepto> conceptos;	
	
	
	
	

	 
	
}
