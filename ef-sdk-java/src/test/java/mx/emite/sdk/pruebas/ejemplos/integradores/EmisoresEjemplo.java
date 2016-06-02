package mx.emite.sdk.pruebas.ejemplos.integradores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.IntegradorAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.request.EmisoresRequest;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.response.EmisoresResponse;
import mx.emite.sdk.scot.response.TokenResponse;

@Slf4j
public class EmisoresEjemplo extends Ejemplo {

	
	@Test public void prueba(){
		try{
			final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
			final TokenRequest tr = TokenRequest.builder()
					.usuario(props.getProperty("integrador.usuario"))
					.contrasena(props.getProperty("integrador.contrasena"))
					.build();
			final TokenResponse tokenresp = api.token().ejecuta(tr);	
			final EmisoresRequest timbresreq = EmisoresRequest.builder()
				.token(tokenresp.getToken())
				
				.build();
			final EmisoresResponse respuesta = api.emisores().ejecuta(timbresreq);
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
}
