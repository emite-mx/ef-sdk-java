package mx.emite.sdk.proxy.response;

import java.util.List;

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

	private Integer timbresRestantes;
	
	private String xml;
	
	private List<InfoCancelacion> info;
	
	public String getXmlDecodificado(){
		return Utilerias.decodificaUtf8(xml);
	}
		
}
