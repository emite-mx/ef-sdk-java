package mx.emite.sdk.cfdi32;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "retenciones" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Retenciones  {

	@XmlElement(name = "Retencion", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @Singular(value="retencion")
	protected List<Retencion> retenciones;

	
}
