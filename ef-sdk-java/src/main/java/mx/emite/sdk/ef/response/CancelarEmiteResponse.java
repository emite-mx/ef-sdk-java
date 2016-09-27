package mx.emite.sdk.ef.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;

@Getter
@Setter
@ToString(callSuper=true)
public class CancelarEmiteResponse extends ScotResponse {

	
	private String mensaje;
	private String acuse;
	private Integer codigo;
	
	
	public CancelarEmiteResponse() {
		
	}

	

	

	
	
	
	
}
