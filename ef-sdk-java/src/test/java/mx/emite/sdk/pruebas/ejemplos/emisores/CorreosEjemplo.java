package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.CorreoRequest;
import mx.emite.sdk.proxy.request.extra.Correo;
import mx.emite.sdk.proxy.request.extra.CorreoParametros;
import mx.emite.sdk.proxy.response.CorreoResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class CorreosEjemplo extends Ejemplo{

	@Test
	public void pruebaCorreos(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final CorreoRequest request = CorreoRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.uuid(props.getProperty("xml.uuid"))
				.plantilla("SUBWAY")
				
				.recuperarArchivos(true)
				.correo(CorreoParametros.builder()
						.asunto(LocalDateTime.now().toString())
						.plantillaUuid(props.getProperty("plantillacorreo"))
						.para(Correo.builder()
								.correo(props.getProperty("destinatario"))
							 	.build())
						.build())
				.build(); 
		final CorreoResponse respuesta = api.correos().ejecuta(request);
		respuesta.guardaPdf(props.getProperty("pdf.ruta"));
		respuesta.guardaXml(props.getProperty("pdf.ruta")+".xml");
		log.debug(respuesta.toString());
		log.debug(respuesta.getPdf());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
