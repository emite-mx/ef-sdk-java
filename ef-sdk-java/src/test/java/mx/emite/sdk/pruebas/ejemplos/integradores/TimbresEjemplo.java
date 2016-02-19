package mx.emite.sdk.pruebas.ejemplos.integradores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.IntegradorAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.request.TimbresRequest;
import mx.emite.sdk.scot.response.TimbresResponse;

@Slf4j
public class TimbresEjemplo extends Ejemplo {

	
	@Test public void prueba(){
		final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
		try{
		final TimbresRequest tr = TimbresRequest.builder()
				.usuario(props.getProperty("integrador.usuario"))
				.contrasena(props.getProperty("integrador.contrasena"))
				.build();
			
		final TimbresResponse respuesta = api.timbres().ejecuta(tr);
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
}
