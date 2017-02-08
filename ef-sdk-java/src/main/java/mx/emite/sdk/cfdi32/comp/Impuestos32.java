package mx.emite.sdk.cfdi32.comp;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "retenciones", "traslados" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Impuestos32{

	@XmlElement(name = "Retenciones", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private Retenciones32 retenciones;
	
	@XmlElement(name = "Traslados", namespace = "http://www.sat.gob.mx/cfd/3")
	@Valid
	private Traslados32 traslados;
	
	@XmlAttribute
	@NotNull @Min(0)
	private BigDecimal totalImpuestosRetenidos;
	
	@XmlAttribute
	@NotNull @Min(0)
	private BigDecimal totalImpuestosTrasladados;

	
}
