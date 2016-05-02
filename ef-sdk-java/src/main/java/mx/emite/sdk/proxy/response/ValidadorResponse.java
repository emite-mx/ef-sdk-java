package mx.emite.sdk.proxy.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoValidacion;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class ValidadorResponse extends ProxyResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2329094578765391410L;

	private Integer timbresRestantes;
	
	private String pdf;
	
	private Boolean valido=false;
	
	private InfoValidacion info;
	
		

	
	
	
	
}
