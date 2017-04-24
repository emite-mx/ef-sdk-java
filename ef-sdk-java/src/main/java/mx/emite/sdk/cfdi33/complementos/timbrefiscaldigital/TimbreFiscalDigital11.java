package mx.emite.sdk.cfdi33.complementos.timbrefiscaldigital;

import java.io.Serializable;
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
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.ComplementoInterface;

@XmlRootElement(name="TimbreFiscalDigital",namespace="http://www.sat.gob.mx/TimbreFiscalDigital")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimbreFiscalDigital11")
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TimbreFiscalDigital11 extends ComplementoInterface implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2058473885101505949L;

	@XmlAttribute(name="Version")
	@NotNull @Pattern(regexp="(1\\.1)",message="Version debe de ser 1.0")
	private final String version="1.1";
	
	@XmlAttribute(name="UUID")
	@NotNull 
	private String UUID;
	
	@XmlAttribute(name="FechaTimbrado")
	@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	@NotNull 
	private LocalDateTime FechaTimbrado;
	
	@XmlAttribute(name="RfcProvCertif")
	@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	@NotNull 
	private String rfcProvCertif;
	
	@XmlAttribute(name="Leyenda")
	private String leyenda;
	
	@XmlAttribute(name="SelloCFD")
	@NotNull 
	private String selloCFD;
	
	@XmlAttribute(name="NoCertificadoSAT")
	@NotNull 
	private String noCertificadoSAT;
	
	@XmlAttribute(name="SelloSAT")
	@NotNull 
	private String selloSAT;
	
	@Override
	public String getEsquemaLocation() {
		return "http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/cfd/TimbreFiscalDigital/TimbreFiscalDigitalv11.xsd";
	}

	@Override
	public String getPrefijo() {
		return "tfd";
	}
	
	
}
