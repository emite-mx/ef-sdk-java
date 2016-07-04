package mx.emite.sdk.ret10;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Totales")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
/**
 * 
 *  <h1>Nodo requerido para expresar el total de las retenciones e información de pagos efectuados en el período que ampara el documento.</h1>
 *	
 * 
 * @author Enrique Sánchez de la Barquera
 * 
 */
public class Totales {

	/**
	 * @param montoTotalOperacion Atributo requerido para expresar  el total del monto de la operación  que se relaciona en el comprobante
	 */
	@XmlAttribute(required = true,name="montoTotOperacion")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montoTotalOperacion;
	
	
	/**
	 * @param montoTotalGravado Atributo requerido para expresar el total del monto gravado de la operación  que se relaciona en el comprobante.
	 */
	@XmlAttribute(required = true,name="montoTotGrav")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montoTotalGravado;
	
	/**
	 * @param montoTotalExento Atributo requerido para expresar el total del monto exento de la operación  que se relaciona en el comprobante.
	 */
	@XmlAttribute(required = true,name="montoTotExent")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montoTotalExento;
	
	/**
	 * @param montoTotalRetenido Atributo requerido para expresar el monto total de las retenciones. Sumatoria de los montos de retención del nodo ImpRetenidos.
	 */
	@XmlAttribute(required = true,name="montoTotRet")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@NotNull
	protected BigDecimal montoTotalRetenido;
	
	/**
	 * @param impuestosRetenidos Nodo opcional para expresar el total de los impuestos retenidos que se desprenden de los conceptos expresados en el documento de retenciones e información de pagos.
	 */
	@XmlElement(required = true,name="ImpRetenidos")
	@Valid @Singular("impuestoRetenido")
	protected List<ImpRetenidos> impuestosRetenidos;
	
}
