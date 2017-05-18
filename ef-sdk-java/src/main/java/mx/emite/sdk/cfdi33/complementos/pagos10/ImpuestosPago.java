package mx.emite.sdk.cfdi33.complementos.pagos10;

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
@XmlType(name = "ImpuestosPago10")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class ImpuestosPago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842376562581175624L;

	@XmlAttribute(name="TotalImpuestosRetenidos")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totalImpuestosRetenidos;
	
	
	@XmlAttribute(name="TotalImpuestosTrasladados")
	@XmlJavaTypeAdapter(ImporteAdapter.class)
	@DecimalMin(value="0",inclusive=true)
	private BigDecimal totalImpuestosTrasladados;
	
	@XmlElement(name="Retenciones", namespace = "http://www.sat.gob.mx/Pagos")
	@Valid
	private RetencionesPago retenciones;
	
	@XmlElement(name="Traslados", namespace = "http://www.sat.gob.mx/Pagos")
	@Valid
	private TrasladosPago traslados;		
}
