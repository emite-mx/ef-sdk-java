package mx.emite.sdk.cfdi32.comp;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import mx.emite.sdk.cfdi32.comp.timbrefiscaldigital.TimbreFiscalDigital;
import mx.emite.sdk.utils.ComplementoInterface;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complemento32 {

	@XmlElement(name="TimbreFiscalDigital")
	@Null
	private TimbreFiscalDigital timbre;

	@XmlTransient @Singular @Valid
	private List<ComplementoInterface> complementos;
	
	


	
	
}
