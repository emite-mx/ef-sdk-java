package mx.emite.sdk.proxy;



import java.io.Serializable;

import lombok.Data;
import mx.emite.sdk.errores.ApiError;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.interfaces.Respuesta;

@Data
public abstract class ProxyResponse implements Serializable,Respuesta{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6372982365342872194L;

	private ApiError error= new ApiError(I_Api_Errores.OK);
	
	private String uuid;
	
	
	
	
}
