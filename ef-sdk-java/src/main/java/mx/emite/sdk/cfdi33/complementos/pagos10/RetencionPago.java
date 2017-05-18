package mx.emite.sdk.cfdi33.complementos.pagos10;

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
import mx.emite.sdk.enums.sat.adaptadores.ImporteAdapter;
import mx.emite.sdk.enums.sat.cfdi33.TiposImpuesto33;
import mx.emite.sdk.enums.sat.cfdi33.adaptadores.TiposImpuesto33Adapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetencionPago10")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetencionPago implements Serializable{



	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7218937409135710960L;

	/**
	 * impuesto Atributo requerido para señalar la clave del tipo de impuesto retenido 
	 */
	@XmlAttribute(name="Impuesto")
	@NotNull
	@XmlJavaTypeAdapter(TiposImpuesto33Adapter.class)
	private TiposImpuesto33 impuesto;
	
	/**
	 * importe Atributo requerido para señalar el monto del impuesto retenido. No se permiten valores negativos.
	 */
	@XmlAttribute(name="Importe")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal importe;
	
	
}
