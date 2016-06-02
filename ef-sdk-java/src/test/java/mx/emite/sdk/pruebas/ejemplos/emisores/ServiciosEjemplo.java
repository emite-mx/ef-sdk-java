package mx.emite.sdk.pruebas.ejemplos.emisores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.response.ServiciosResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class ServiciosEjemplo extends Ejemplo {

	@Test
	public void prueba(){
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		try{
		ServiciosResponse respuesta = api.servicios().ejecuta();
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
	
}
