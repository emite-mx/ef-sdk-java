package mx.emite.sdk.cfdi32.comp;

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
@XmlType(name = "", propOrder = { "traslados" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Traslados32 {

	@XmlElement(name = "Traslado", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
	@Valid @Singular("traslado")
	protected List<Traslado32> traslados;

	
}
