package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

@Data
@ApiObject
public class InfoValidacionPartida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344316892383217550L;

	@JsonIgnore
	private Boolean cfdi;
	
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@ApiObjectField(description="fecha del cfdi/tfd",required=true)
	private LocalDateTime fecha;
	@ApiObjectField(description="días transcurridos",required=true)
	private Long dias;
	@ApiObjectField(description="bandera que indica si la estructura del cfdi/tfd es correcta o no")
	private Boolean estructura=true;
	@ApiObjectField(description="número de certificado del cfd/tfd")
	private String certificadoUsado;
	@ApiObjectField(description="número de certificado reportado en el cfd/tfd")
	private String certificadoReportado;
	@ApiObjectField(description="bandera que indica si el certificado esta vigente en el momento de la expedición")
	private Boolean vigente;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@ApiObjectField(description="fecha de inicio de vigencia del certificado")
	private LocalDateTime inicioVigencia;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@ApiObjectField(description="fecha de termino de vigencia del certificado")
	private LocalDateTime terminoVigencia;
	@ApiObjectField(description="cadena original del cfdi / tfd")
	private String cadenaOriginal;
	@ApiObjectField(description="bandera que indica si el sello del cfdi / tfd es correcto o no")
	private Boolean selloValido=false;
	@ApiObjectField(description="bandera que indica si el certificado es un CSD (en caso de que sea falso se trata de FIEL)")
	private Boolean esCsd=true;
	@ApiObjectField(description="sello del cfdi / tfd")
	private String sello;
	@ApiObjectField(description="hash de la cadena original")
	private String hash;
	
	@Deprecated
	public InfoValidacionPartida(){
		
	}
	
	
	public InfoValidacionPartida(boolean escfdi){
		this.cfdi=escfdi;
	}
}
