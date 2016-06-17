package mx.emite.sdk.errores;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.jsondoc.core.annotation.ApiObjectField;

import lombok.Data;

@Data
public class ApiError implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4030359789851204645L;


	@ApiObjectField(name="codigo",description="Elemento numérico que contiene el código de error",order=1,required=true)	
	private Integer codigo;
	
	@ApiObjectField(name="descripcion",description="Elemento que contiene el mensaje que corresponde al código de error",order=2,required=true)
	private String descripcion;
	 
	@ApiObjectField(name="errores",description="Lista de errores detectados",order=3,required=false)
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
	
	
	
	public boolean ok() {
		return this.codigo.equals(I_Api_Errores.OK.getId());
	}
	
	
	public String getHtml(){
		final StringBuilder res = new StringBuilder("<b>").append(codigo.toString()).append("</b>");
		if(descripcion!=null)
			res.append(" ").append(descripcion);
		if(errores!=null)
			errores.stream().forEach(i->res.append("<br/>").append(i));
		
		return res.toString();
	}

	
	
}
