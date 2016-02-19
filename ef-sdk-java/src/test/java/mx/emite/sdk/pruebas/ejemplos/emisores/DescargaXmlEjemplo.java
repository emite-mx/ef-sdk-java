package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.XmlRequest;
import mx.emite.sdk.proxy.response.XmlResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class DescargaXmlEjemplo extends Ejemplo{

	@Test
	public void pruebaDescarga(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final XmlRequest request = XmlRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
				.build()
				; 
		
		final XmlResponse respuesta = api.descargaxml().ejecuta(request);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
