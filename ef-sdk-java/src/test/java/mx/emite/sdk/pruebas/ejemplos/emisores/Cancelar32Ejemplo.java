package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CancelarRequest;
import mx.emite.sdk.proxy.response.CancelarResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class Cancelar32Ejemplo extends Ejemplo{

	@Test
	public void pruebaSinPfx(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final CancelarRequest request = CancelarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
				.build()
				; 
		
		final CancelarResponse respuesta = api.cancelador32().ejecuta(request);
		
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}