package mx.emite.sdk.cfdi32;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.serializers.LocalDateTimeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimbreFiscalDigital")
@XmlRootElement(name = "TimbreFiscalDigital")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TimbreFiscalDigital{

	
	@XmlAttribute(required = true)
	@NotNull
	protected String selloSAT;

	@XmlAttribute(required = true)
	@NotNull
	protected String noCertificadoSAT;

	@XmlAttribute(required = true)
	@NotNull
	protected String selloCFD;

	@XmlAttribute(required = true, name = "FechaTimbrado")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@NotNull
	protected LocalDateTime FechaTimbrado;

	@XmlAttribute(required = true, name = "UUID")
	@NotNull
	protected String UUID;

	@XmlAttribute(required = true)
	@NotNull
	protected String version = "1.0";

	
}
