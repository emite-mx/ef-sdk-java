package mx.emite.sdk.cfdi32.nomina12;

import java.util.List;

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
import lombok.Singular;
import mx.emite.sdk.cfdi32.comp.timbrefiscaldigital.TimbreFiscalDigital;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Complemento")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Complemento {

	@XmlElement(name="TimbreFiscalDigital",namespace="http://www.sat.gob.mx/TimbreFiscalDigital")
	@Null
	private TimbreFiscalDigital timbre;

	@XmlElement(name = "Nomina", namespace="http://www.sat.gob.mx/nomina12")
	@Valid
	@NotNull
	@Singular(value="nomina")
	private List<Nomina> nominas;
}
