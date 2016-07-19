package mx.emite.sdk.ret10;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.enums.sat.TipoImpuestoRetenciones;
import mx.emite.sdk.enums.sat.TipoPagoRetencion;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TipoPagoRetencionAdapter;
import mx.emite.sdk.enums.sat.adaptadores.TiposImpuestoRetencionesAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImpRetenidos")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 *  <h1>Nodo opcional para expresar el total de los impuestos retenidos que se desprenden de los conceptos expresados en el documento de retenciones e información de pagos.</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 * 
 */
public class ImpRetenidos {

	/**
	 *  baseRetencion Atributo opcional para expresar la  base del impuesto, que puede ser la diferencia entre los ingresos percibidos y las deducciones autorizadas
	 */
	@XmlAttribute(required = false,name="BaseRet")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal baseRetencion;
	
	/**
	 *  impuesto Atributo opcional para señalar el tipo de impuesto retenido del periodo o ejercicio conforme al catálogo.
	 */
	@XmlAttribute(required = false,name="Impuesto")
	@XmlJavaTypeAdapter(TiposImpuestoRetencionesAdapter.class)
	protected TipoImpuestoRetenciones impuesto;
	
	/**
	 *  montoRet Atributo requerido para expresar el importe del impuesto retenido en el periodo o ejercicio
	 */
	@XmlAttribute(required = false,name="montoRet")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	protected BigDecimal montoRetencion;
	
	/**
	 *  tipoPagoRetencion Atributo requerido para precisar si el monto de la retención es considerado pago definitivo o pago provisional
	 */
	@XmlAttribute(required = true,name="TipoPagoRet")
	@XmlJavaTypeAdapter(TipoPagoRetencionAdapter.class)
	@NotNull
	protected TipoPagoRetencion tipoPagoRetencion;
	
	
	
}
