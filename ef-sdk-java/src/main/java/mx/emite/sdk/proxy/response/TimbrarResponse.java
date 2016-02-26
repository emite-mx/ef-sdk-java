package mx.emite.sdk.proxy.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoCfdi;
import mx.emite.sdk.utils.Utilerias;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class TimbrarResponse extends ProxyResponse {

	private Integer timbresRestantes;
	
	private String xml;
	
	private InfoCfdi info;
	
	public void guardaXml(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,Utilerias.decodifica64Utf8Byte(xml));		
	}
	
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
	
	
}
