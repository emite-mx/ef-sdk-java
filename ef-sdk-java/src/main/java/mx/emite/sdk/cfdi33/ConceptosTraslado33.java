package mx.emite.sdk.cfdi33;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
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
import mx.emite.sdk.enums.sat.adaptadores.Importe6Adapter;
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.cfdi33.TiposFactor33;
import mx.emite.sdk.enums.sat.cfdi33.TiposImpuesto33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposFactor33Adapter;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposImpuesto33Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptosTraslado33 implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2293892408669168381L;

	/**
	 * base Atributo requerido para señalar la base para el cálculo del impuesto, la determinación de la base se realiza de acuerdo con las disposiciones fiscales vigentes. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Base")
	@NotNull
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal base;
	
	/**
	 * impuesto Atributo requerido para señalar la clave del tipo de impuesto trasladado aplicable al concepto.
	 */
	@XmlAttribute(name="Impuesto")
	@NotNull
	@XmlJavaTypeAdapter(TiposImpuesto33Adapter.class)
	private TiposImpuesto33 impuesto;
	
	/**
	 * tipoFactor Atributo requerido para señalar la clave del tipo de factor que se aplica a la base del impuesto.
	 */
	@XmlAttribute(name="TipoFactor")
	@NotNull
	@XmlJavaTypeAdapter(TiposFactor33Adapter.class)
	private TiposFactor33 tipoFactor;
	
	/**
	 * tasaOCuota Atributo condicional para señalar el valor de la tasa o cuota del impuesto que se traslada para el presente concepto. Es requerido cuando el atributo TipoFactor tenga una clave que corresponda a Tasa o Cuota.
	 */
	@XmlAttribute(name="TasaOCuota")
	@NotNull
	@XmlJavaTypeAdapter(Importe6Adapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal tasaOCuota;
	
	/**
	 * importe Atributo condicional para señalar el importe del impuesto trasladado que aplica al concepto. No se permiten valores negativos. Es requerido cuando TipoFactor sea Tasa o Cuota
	 */
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal importe;
	
	
}
