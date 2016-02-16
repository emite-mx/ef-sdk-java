package mx.emite.sdk.proxy;



import lombok.Data;
import mx.emite.sdk.errores.ApiError;
import mx.emite.sdk.errores.I_Api_Errores;

@Data
public abstract class ProxyResponse {

	
	private ApiError error= new ApiError(I_Api_Errores.OK);
	
	private String uuid;
	
	
	
	
}
