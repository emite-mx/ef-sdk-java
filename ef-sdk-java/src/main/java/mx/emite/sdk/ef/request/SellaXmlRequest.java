package mx.emite.sdk.ef.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor

public class SellaXmlRequest {

	@NotNull
	private String tokenEmite;
	
	private String usuario;

	private String contrasena;	
	
	private String co;

	
	 
	
}
