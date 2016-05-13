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
public class PdfResponse extends ProxyResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781942089550712419L;
	private String pdf;
	
	public byte[] getPdfDecodificado() throws ApiException{
		
		return Utilerias.decodificaBinario(pdf);
		
	}

	public void guardaPdf(String ruta) throws ApiException{
		
		Utilerias.guardaArchivo(ruta,getPdfDecodificado());
		
	}
	
	
		
	
	
}
