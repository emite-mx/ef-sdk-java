package mx.emite.sdk.proxy.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.ProxyResponse;
import mx.emite.sdk.proxy.response.extra.InfoCfdi;
import mx.emite.sdk.proxy.response.extra.InfoDpIva;
import mx.emite.sdk.proxy.response.extra.InfoRetenciones;
import mx.emite.sdk.utils.Utilerias;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class TimbrarResponse extends ProxyResponse implements RespuestaTimbrado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6076627368662272834L;

	private Integer timbresRestantes;
	
	private String xml;
	
	private InfoCfdi info;
	private InfoRetenciones ret;
	private InfoDpIva dpiva;
	
	
	public void guardaXml(String ruta) throws ApiException{
		Utilerias.guardaArchivo(ruta,Utilerias.decodifica64Utf8Byte(xml));		
	}
	
	public String getXmlDecodificado(){
		return Utilerias.decodifica64Utf8(xml);
	}
	
	@JsonIgnore
	public byte[] getXmlDecodificadoBinario(){
		return Utilerias.decodifica64Utf8Byte(xml);
	}
	
	@Override
	public String getInfo_Uuid() {
		if(info!=null)
			return info.getUuid();
		return null;
	}

	@Override
	public LocalDateTime getInfo_Fecha() {
		if(info!=null)
			return info.getFecha();
		return null;
	}
	
	@Override
	public String getInfo_Serie() {
		if(info!=null)
			return info.getSerie();
		return null;
	}
	
	@Override
	public String getInfo_Receptor() {
		if(info!=null)
			return info.getReceptor();
		return null;
	}
	
	@Override
	public String getInfo_Folio() {
		if(info!=null)
			return info.getFolio();
		return null;
	}
	
}
