package mx.emite.sdk.proxy.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface RespuestaTimbrado extends Serializable{

	

	public byte[] getXmlDecodificadoBinario();

	public String getInfo_Uuid();

	public LocalDateTime getInfo_Fecha();
	public String getInfo_Folio();
	public String getInfo_Receptor();
	public String getInfo_Serie();
	
}
