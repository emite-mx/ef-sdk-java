package mx.emite.sdk.proxy.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.emite.sdk.proxy.ProxyResponse;

@Data
@EqualsAndHashCode(callSuper=true)
public class ServiciosResponse extends ProxyResponse {

	
	private List<String> servicios = new ArrayList<>();
	
	
		
	
	
	
}
