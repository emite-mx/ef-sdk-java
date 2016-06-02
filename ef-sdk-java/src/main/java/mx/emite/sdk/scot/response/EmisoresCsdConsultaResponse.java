package mx.emite.sdk.scot.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;
import mx.emite.sdk.serializers.FechaHoraDeserializer;

@Getter
@Setter
@ToString(callSuper=true)
public class EmisoresCsdConsultaResponse extends ScotResponse {

	/**
	 * @param csd Si el emisor cuenta con csd la variable csd será verdadera, de lo contrario falsa
	 */
	
	private Boolean csd;

	/**
	 * @param noCertificado No. de certificado del CSD
	 */
	private String noCertificado;
	
	/**
	* @param vencimiento Fecha de vencimiento del certificado
	*
	*/
	@JsonDeserialize(using=FechaHoraDeserializer.class)
	private LocalDateTime vencimiento;
	
	


	
	
	
}
