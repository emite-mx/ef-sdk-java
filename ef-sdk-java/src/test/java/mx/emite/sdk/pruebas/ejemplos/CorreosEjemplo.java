package mx.emite.sdk.pruebas.ejemplos;

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
				.plantilla("EMITE")
				.recuperarArchivos(true)
				.correo(CorreoParametros.builder()
						.asunto("asunto")
						.para(Correo.builder()
								.correo(props.getProperty("destinatario"))
							 	.build())
						.build())
				.build(); 
		final CorreoResponse respuesta = api.correos().ejecuta(request);
		procesaRespuesta(respuesta);
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
