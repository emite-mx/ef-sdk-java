package mx.emite.sdk.cfdi32.comp;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "conceptos" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conceptos32 {

	@XmlElement(name = "Concepto", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@NotEmpty @Valid @Singular
	private List<Concepto32> conceptos;

	
}
