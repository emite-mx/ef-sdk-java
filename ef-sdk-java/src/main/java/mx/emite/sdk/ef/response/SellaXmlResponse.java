package mx.emite.sdk.ef.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.emite.sdk.scot.ScotResponse;

@Getter
@Setter
@ToString(callSuper=true)
public class SellaXmlResponse extends ScotResponse {

	private String sello;
	
	private String noCertificado;
	
	private String certificado;
	
	private String vencimiento;
	

	
}
