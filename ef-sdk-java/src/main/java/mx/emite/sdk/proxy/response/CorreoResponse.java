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
public class CorreoResponse extends ProxyResponse {

	private String xml;
	
	private String pdf;
	
	public byte[] getPdfDecodificado() throws ApiException{
		return Utilerias.decodificaBinario(pdf);
	}

	public void guardaPdf(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,getPdfDecodificado());		
	}
	public void guardaXml(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,Utilerias.decodifica64Utf8Byte(xml));		
	}
	
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
	
	public byte[] getXmlDecodificadoBinario(){
		return Utilerias.decodifica64Utf8Byte(xml);
	}
	
}
