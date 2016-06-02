package mx.emite.sdk.proxy.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 5836695054771320915L;
	private String xml;
	
	
	@JsonIgnore
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
	
	@JsonIgnore
	public void guardaXml(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,Utilerias.decodifica64Utf8Byte(xml));		
	}

	@JsonIgnore
	public byte[] getXmlDecodificadoBinario() {
		return Utilerias.decodifica64Utf8Byte(xml);
	}
	
	
	
}
