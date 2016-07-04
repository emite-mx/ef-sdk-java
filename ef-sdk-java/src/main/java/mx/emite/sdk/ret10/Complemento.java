package mx.emite.sdk.ret10;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.ret10.comp.ComplementoInterface;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Complemento")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Complemento {

	/*@XmlElement(name="EnajenaciondeAcciones",namespace="http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones")
	private EnajenaciondeAcciones enajenaciondeAcciones;
	*/
	@XmlTransient @Singular @Valid
	private List<ComplementoInterface> complementos;
}
