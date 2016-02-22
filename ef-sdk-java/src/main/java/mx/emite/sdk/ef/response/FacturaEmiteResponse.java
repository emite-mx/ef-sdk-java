package mx.emite.sdk.ef.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;

@Getter
@Setter
@ToString(callSuper=true)
public class FacturaEmiteResponse extends ScotResponse {

	
	
	
	private String uuid;
	
	private String serie;
	
	private Integer folio;
	
	private String vencimiento;
	
		
}
