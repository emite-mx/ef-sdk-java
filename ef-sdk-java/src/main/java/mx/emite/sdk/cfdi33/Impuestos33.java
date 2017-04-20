package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",propOrder={"retenciones","traslados"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Impuestos33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5684478217647808755L;

	/**
	 * totalImpuestosRetenidos Atributo condicional para expresar el total de los impuestos retenidos que se desprenden de los conceptos expresados en el comprobante fiscal digital por Internet. No se permiten valores negativos. Es requerido cuando en los conceptos se registren impuestos retenidos
	 */
	@XmlAttribute(name="TotalImpuestosRetenidos")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totalImpuestosRetenidos;
	
	/**
	 * totalImpuestosTrasladados Atributo condicional para expresar el total de los impuestos trasladados que se desprenden de los conceptos expresados en el comprobante fiscal digital por Internet. No se permiten valores negativos. Es requerido cuando en los conceptos se registren impuestos trasladados.
	 */
	@XmlAttribute(name="TotalImpuestosTrasladados")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totalImpuestosTrasladados;
	
	/**
	 * retenciones Nodo requerido para la información detallada de una retención de impuesto específico.
	 */
	@XmlElement(name="Retenciones", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private Retenciones33 retenciones;
	
	
	/**
	 * traslados Nodo condicional para capturar los impuestos trasladados aplicables. Es requerido cuando en los conceptos se registre un impuesto trasladado.
	 */
	@XmlElement(name="Traslados", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private Traslados33 traslados;

	

	
}
