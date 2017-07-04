package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.EstatusRequest;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.response.EmisoresEstatusResponse;

@Slf4j
public class EstatusEjemplo extends Ejemplo{

	@Test
	public void pruebaEstatus(){
		try{
		@SuppressWarnings("deprecation")
		final EmiteAPI api = new EmiteAPI(Ambiente.LOCAL);
		final EstatusRequest request = EstatusRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.cuentasporpagar(true)
				.documentacion(true)
				.build(); 
		final EmisoresEstatusResponse respuesta = api.estatus().ejecuta(request);
		//respuesta.guardaPdf(props.getProperty("pdf.ruta"));
		//respuesta.guardaXml(props.getProperty("pdf.ruta")+".xml");
		log.debug(respuesta.toString().replace(",", ",\n"));
		//log.debug(respuesta.getPdf());
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
