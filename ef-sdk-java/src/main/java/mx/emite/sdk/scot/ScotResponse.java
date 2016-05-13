package mx.emite.sdk.scot;

import lombok.Data;
import mx.emite.sdk.errores.ApiError;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.interfaces.Respuesta;

@Data
public class ScotResponse implements Respuesta {
	
	private ApiError error= new ApiError(I_Api_Errores.OK);
	private Integer idIntegrador;
	private Integer idEmisor;
	private String uuid;
	
}
