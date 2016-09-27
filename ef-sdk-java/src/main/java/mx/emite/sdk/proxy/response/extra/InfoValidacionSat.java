package mx.emite.sdk.proxy.response.extra;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@ApiObject
public class InfoValidacionSat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400924444546296754L;
	@ApiObjectField(description="bandera que indica si se realizó con éxito la consulta ante el SAT")
	private Boolean consulta;
	@ApiObjectField(description="código de respuesta de la consulta ante el SAT")
	private String codigo;
	@ApiObjectField(description="estado del comprobante ante el sat")
	private String estado;

	
	@JsonIgnore
	public String getServicio() {
		if(consulta)
		 return "OK Consulta realizada exitosamente";
		return "ERROR realizando consulta";
	}
}
