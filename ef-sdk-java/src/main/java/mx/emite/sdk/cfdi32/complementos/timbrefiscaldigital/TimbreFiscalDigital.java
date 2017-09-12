package mx.emite.sdk.cfdi32.complementos.timbrefiscaldigital;

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
import mx.emite.sdk.serializers.LocalDateTimeAdapter;
import mx.emite.sdk.utils.ComplementoInterface;

@XmlRootElement(name="TimbreFiscalDigital",namespace="http://www.sat.gob.mx/TimbreFiscalDigital")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimbreFiscalDigital")
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TimbreFiscalDigital extends ComplementoInterface implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7573094384891339893L;

	@XmlAttribute(name="version")
	@NotNull @Pattern(regexp="(1\\.0)",message="Version debe de ser 1.0")
	private final String version="1.0";
	
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

	@Override
	public String getPrefijo() {
		return "tfd";
	}
	
	public static TimbreFiscalDigital nuevo() {
		return builder().build();
	}
	
	@Deprecated
	public TimbreFiscalDigital() {
	}
	
}
