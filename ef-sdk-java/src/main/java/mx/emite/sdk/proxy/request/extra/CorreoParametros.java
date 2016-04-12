package mx.emite.sdk.proxy.request.extra;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class CorreoParametros {


	private String asunto;
	private String plantillaUuid;
	
	@NotEmpty @Valid
	@JsonProperty(value="para")
	@Singular
	private List<Correo> paras;
	
	@Valid 
	@JsonProperty(value="cc")
	@Singular
	private List<Correo> ccs;
	
	@Valid
	@JsonProperty(value="bcc")
	@Singular
	private List<Correo> bccs;
	
	@Valid
	private Correo responderA;
	

	


	

	

	
}
