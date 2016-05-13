package mx.emite.sdk.proxy.request.extra;

import org.hibernate.validator.constraints.Email;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Correo {

	private String nombre;
	
	@Email
	private String correo;

	
	
}
