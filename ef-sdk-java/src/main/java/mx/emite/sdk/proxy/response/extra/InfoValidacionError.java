package mx.emite.sdk.proxy.response.extra;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.emite.sdk.errores.ApiException;

@Data
@NoArgsConstructor
public class InfoValidacionError {

	private Integer codigo;
	private String descripcion;
	private String traza;
	private List<String> mensajes; 
	
	public InfoValidacionError(ApiException api) {
		this.codigo=api.getError().getId();
		this.descripcion=api.getError().getDescripcion();
		this.mensajes=api.getErrores();
		this.traza = ExceptionUtils.getStackTrace(api);
	}
	
	
	
}
