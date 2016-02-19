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
public class ZipResponse extends ProxyResponse {

	
	private Long totalTimbres;
	
	
	private String zip;
	
	public byte[] getZipDecodificado() throws ApiException{
		
		return Utilerias.decodificaBinario(zip);
		
	}

	public void guardaZip(String ruta) throws ApiException{
		
		Utilerias.guardaUrl(ruta,zip);
		
	}

	
	
}
