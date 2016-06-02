package mx.emite.sdk.proxy.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoCancelacion;
import mx.emite.sdk.utils.Utilerias;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class CancelarResponse extends ProxyResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4366917477059471931L;

	private Integer timbresRestantes;
	
	private String xml;
	
	private List<InfoCancelacion> info;
	
	@JsonIgnore
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
		
}
