package mx.emite.sdk.ef.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;

@Getter
@Setter
@ToString(callSuper=true)
public class TokenConsumoResponse extends ScotResponse {

	
	
	private String tokenConsumo;
	

	private Boolean puedeTimbrar;
	
	
	private Integer asignados;
	
	
	private Integer consumidos;
	
	
	private Integer restantes;

	
	private String rfcEmisor;
	
	
	
	
		
}
