package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

@Data
public class InfoValidacionPartida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5344316892383217550L;

	@JsonIgnore
	private Boolean cfdi;
	
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fecha;
	private Long dias;
	private Boolean estructura=true;
	private String certificadoUsado;
	private String certificadoReportado;
	private Boolean vigente;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime inicioVigencia;
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime terminoVigencia;
	private String cadenaOriginal;
	private Boolean selloValido=false;
	private Boolean esCsd=true;
	private String sello;
	private String hash;
	
	@Deprecated
	public InfoValidacionPartida(){
		
	}
	
	
	public InfoValidacionPartida(boolean escfdi){
		this.cfdi=escfdi;
	}
}
