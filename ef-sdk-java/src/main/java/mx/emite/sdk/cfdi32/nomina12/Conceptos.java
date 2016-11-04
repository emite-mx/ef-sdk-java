package mx.emite.sdk.cfdi32.nomina12;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "concepto" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conceptos {

	@XmlElement(name = "Concepto", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@NotNull @Valid 
	private Concepto concepto;

	
}
