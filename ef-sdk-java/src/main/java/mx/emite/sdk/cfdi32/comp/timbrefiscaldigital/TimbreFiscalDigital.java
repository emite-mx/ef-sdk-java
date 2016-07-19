package mx.emite.sdk.cfdi32.comp.timbrefiscaldigital;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mx.emite.sdk.ret10.comp.ComplementoInterface;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;

@XmlRootElement(name="TimbreFiscalDigital",namespace="http://www.sat.gob.mx/TimbreFiscalDigital")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimbreFiscalDigital")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TimbreFiscalDigital extends ComplementoInterface{

	@XmlAttribute(name="version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private String version="1.0";
	
	@XmlAttribute(name="UUID")
	@NotNull 
	private String UUID;
	
	@XmlAttribute(name="FechaTimbrado")
	@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	@NotNull 
	private LocalDateTime FechaTimbrado;
	
	@XmlAttribute(name="selloCFD")
	@NotNull 
	private String selloCFD;
	
	@XmlAttribute(name="noCertificadoSAT")
	@NotNull 
	private String noCertificadoSAT;
	
	@XmlAttribute(name="selloSAT")
	@NotNull 
	private String selloSAT;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/timbrefiscaldigital/TimbreFiscalDigital.xsd";
	}
	
	
}
