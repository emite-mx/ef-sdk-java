package mx.emite.sdk.proxy.response.extra;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import mx.emite.sdk.serializers.FechaHoraDeserializer;

@Data
public class InfoCancelacion {

	private final String uuid;
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime fechaCancelacion;
	private final Integer estatus;
	private final String descripcion;
	private final String selloCFD;
	
	public InfoCancelacion(){
		this.uuid=null;
		this.estatus=null;
		this.descripcion=null;
		this.selloCFD=null;
	}
	
}
