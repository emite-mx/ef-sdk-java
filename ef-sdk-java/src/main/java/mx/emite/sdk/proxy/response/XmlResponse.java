package mx.emite.sdk.proxy.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.utils.Utilerias;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class XmlResponse extends ProxyResponse {

	private String xml;
	
	
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
	
	public void guardaXml(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,Utilerias.decodifica64Utf8Byte(xml));		
	}
	
	
	
}
