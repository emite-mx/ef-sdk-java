package mx.emite.sdk.proxy.request.extra;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PdfParametros {

	@NotNull
	private String nombre;
	
	@NotNull
	private String valor;

	
	

	
}
