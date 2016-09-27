package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiObject
public class InfoValidacionError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4187373783593201623L;
	@ApiObjectField(description="código de error")
	private Integer codigo;
	@ApiObjectField(description="descripción del error")
	private String descripcion;
	@ApiObjectField(description="traza del error")
	private String traza;
	@ApiObjectField(description="mensajes adicionales")
	private List<String> mensajes; 
	
	@JsonIgnore
	public String getError(){
		return (codigo==null?"":"EMITE["+codigo+"]: ")+ descripcion+(mensajes==null||mensajes.isEmpty()?"":Arrays.toString(mensajes.toArray()));
	}
	
	
	
}
