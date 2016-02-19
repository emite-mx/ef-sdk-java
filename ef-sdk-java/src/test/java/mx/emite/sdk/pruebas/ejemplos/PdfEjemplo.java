package mx.emite.sdk.pruebas.ejemplos;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.PdfRequest;
import mx.emite.sdk.proxy.response.PdfResponse;

@Slf4j
public class PdfEjemplo extends Ejemplo{

	@Test
	public void pruebaPdf(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final PdfRequest request = PdfRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.uuid(props.getProperty("xml.uuid"))
				.plantilla("EMITE")
				.build()
				; 
		final PdfResponse respuesta = api.pdf().ejecuta(request);
		procesaRespuesta(respuesta);
		respuesta.guardaPdf(props.getProperty("pdf.ruta"));
		log.debug(respuesta.toString());
		log.debug(respuesta.getPdf());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
