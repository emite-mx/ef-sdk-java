package mx.emite.sdk.scot.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.utils.FechaHoraDeserializer;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class TokenResponse extends ScotResponse {

	
	
	private String token;

	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime vigenciaInicio;

	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime vigenciaTermino;

	
	
	
	
	
}
