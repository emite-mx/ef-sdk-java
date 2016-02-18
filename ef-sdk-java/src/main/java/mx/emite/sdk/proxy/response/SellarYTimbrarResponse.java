package mx.emite.sdk.proxy.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoCfdi;
import mx.emite.sdk.utils.Utilerias;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class SellarYTimbrarResponse extends ProxyResponse {

	private Integer timbresRestantes;
	private String cadenaOriginal;
	private String xml;
	private InfoCfdi info;
	
	public String getXmlDecodificado(){
		return Utilerias.decodificaUtf8(xml);
	}
	
	
}
