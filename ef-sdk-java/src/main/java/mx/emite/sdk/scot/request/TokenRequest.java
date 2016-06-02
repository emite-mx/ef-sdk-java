package mx.emite.sdk.scot.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenRequest {

	
	private String usuario;
	
	
	private String contrasena;
	
		
	
}
