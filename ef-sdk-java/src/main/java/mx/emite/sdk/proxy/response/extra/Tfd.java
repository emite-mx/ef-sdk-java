package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Tfd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1546984296223993024L;
	private String v;
	private String uuid;
	private String selloSat;
	private String selloCFD;
	
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@XmlPath("cfdi:Complemento/tfd:TimbreFiscalDigital/@FechaTimbrado")
	//@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	private LocalDateTime fecha;
	
	private String certPac;
	private String rfcPac;
	private String cadenaTfd;
	
}
