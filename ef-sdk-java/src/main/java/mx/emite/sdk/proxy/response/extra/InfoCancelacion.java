package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

@Data
@EqualsAndHashCode(callSuper=false)
public class InfoCancelacion extends Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3347532633354990822L;
	private final String uuid;
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	@JsonSerialize(using=FechaHoraSerializer.class)
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
