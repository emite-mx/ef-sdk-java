package mx.emite.sdk.pruebas.ejemplos;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CancelarRequest;
import mx.emite.sdk.proxy.response.CancelarResponse;

@Slf4j
public class Cancelar32Ejemplo extends Ejemplo{

	
	
	
	@Test
	public void pruebaSinPfx(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final CancelarRequest request = CancelarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.uuid("7F418ECE-547B-A2F9-F81B-BB1A4008A06D")
				.build()
				; 
		
		final CancelarResponse respuesta = api.cancelador32().ejecuta(request);
		procesaRespuesta(respuesta);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
