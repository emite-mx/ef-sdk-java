package mx.emite.sdk.scot.response.extra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import mx.emite.sdk.enums.TipoFacturas;
import mx.emite.sdk.serializers.FechaHoraDeserializer;

/**
 *  <h1>Cuentas por Pagar</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 *
 */
@Data
public class CuentasPorPagar {

	/**
	 * @return tipoFactura Tipo de la factura
	 */
	private TipoFacturas tipoFactura;

	/**
	 * @return serie Número de serie
	 */
	private String serie;
	
	/**
	 * @return folio Número de folio
	 */
	private Integer folio;
	
	/**
	 * @return subtotal subtotal
	 */
	private BigDecimal subtotal;
	
	/**
	 * @return iva Monto de iva
	 */
	private BigDecimal iva;
	
	/**
	 * @return total total original de la factura
	 */
	private BigDecimal total;
	
	/**
	 * @return saldo por pagar
	 */
	private BigDecimal saldo;
	
	/**
	 * @return fecha de la factura
	 */
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fecha;
	
	/**
	 * @return fecha de vencimiento
	 */
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime vencimiento;
	
	/**
	 * @return vencida si la cuenta esta vencida o no
	 */
	private Boolean vencida;
	
	
	public String getSerieFolio(){
		if(serie==null)
			return folio.toString();
		return serie.concat(" - ").concat(folio.toString());
	}
	
	

}
