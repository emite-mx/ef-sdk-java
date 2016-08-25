package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class InfoValidacionSat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400924444546296754L;
	private Boolean consulta;
	private String codigo;
	private String estado;

	
	@JsonIgnore
	public String getServicio() {
		if(consulta)
		 return "OK Consulta realizada exitosamente";
		return "ERROR realizando consulta";
	}
}
