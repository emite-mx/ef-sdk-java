package mx.emite.sdk.errores;

import java.util.Collections;
import java.util.List;

import lombok.Data;

@Data
public class ApiError {

	
	private Integer codigo;
	
	
	private String descripcion;
	
	
	private List<String> errores;
	
	public ApiError(){
		
	}
	public ApiError(I_Api_Errores e){
		this(e,Collections.emptyList());
	}

	
	public ApiError(I_Api_Errores e,String errores){
		this(e,Collections.singletonList(errores));
	}
	
	public ApiError(I_Api_Errores e,List<String> errores){
		this.codigo=e.getId();
		this.descripcion=e.getDescripcion();
		this.errores=errores;
	}
	
	public ApiError(ApiException api) {
		this.codigo=api.getError().getId();
		this.descripcion=api.getError().getDescripcion();
		this.errores=api.getErrores();
	}
	
	
	

	
	
}
