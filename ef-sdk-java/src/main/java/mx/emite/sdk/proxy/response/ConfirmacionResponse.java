package mx.emite.sdk.proxy.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.serializers.FechaHoraDeserializer;
import mx.emite.sdk.serializers.FechaHoraSerializer;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class ConfirmacionResponse extends ProxyResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6063730888762356789L;

	private String confirmacion;
	
	@JsonSerialize(using=FechaHoraSerializer.class)
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime vigencia;
	
		
	
	
}
