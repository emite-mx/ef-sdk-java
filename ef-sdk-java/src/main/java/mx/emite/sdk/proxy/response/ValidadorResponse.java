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

	private Integer timbresRestantes;
	
	private String pdf;
	
	private Boolean valido=false;
	
	private InfoValidacion info;
	
		

	
	
	
	
}
