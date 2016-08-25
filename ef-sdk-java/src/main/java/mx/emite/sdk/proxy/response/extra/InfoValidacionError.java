package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoValidacionError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4187373783593201623L;
	private Integer codigo;
	private String descripcion;
	private String traza;
	private List<String> mensajes; 
	
	@JsonIgnore
	public String getError(){
		return (codigo==null?"":"EMITE["+codigo+"]: ")+ descripcion+(mensajes==null||mensajes.isEmpty()?"":Arrays.toString(mensajes.toArray()));
	}
	
	
	
}
