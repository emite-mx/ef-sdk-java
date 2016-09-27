package mx.emite.sdk.proxy;



import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObjectField;

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

	@ApiObjectField(name="error",description="Elemento que contiene el resultado de la operación ejecutada en el WS",order=1,required=true,processtemplate=true)	
	private ApiError error= new ApiError(I_Api_Errores.OK);;
	
	@ApiObjectField(name="uuid",description="Uuid de bitácora de petición ",order=1,required=true,processtemplate=true)	
	private String uuid;
	
	
	
	
}
