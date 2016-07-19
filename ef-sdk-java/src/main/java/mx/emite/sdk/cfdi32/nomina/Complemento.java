package mx.emite.sdk.cfdi32.nomina;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.comp.timbrefiscaldigital.TimbreFiscalDigital;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complemento {

	@XmlElement(name="TimbreFiscalDigital")
	@Null
	private TimbreFiscalDigital timbre;

	@XmlElement(name = "Nomina", namespace="http://www.sat.gob.mx/nomina")
	@Valid
	@NotNull
	private Nomina nomina;
	
	


	
	
}
