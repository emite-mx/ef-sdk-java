package mx.emite.sdk.cfdi32;

import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.cfdi32.complementos.timbrefiscaldigital.TimbreFiscalDigital;


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

	

	
	
}
