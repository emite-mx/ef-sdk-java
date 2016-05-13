package mx.emite.sdk.pruebas.ejemplos.integradores;

import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.IntegradorAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.request.EmisoresDocumentosRequest;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.response.EmisoresDocumentosResponse;
import mx.emite.sdk.scot.response.TokenResponse;

@Slf4j
public class EmisoresDocumentosEjemplo extends Ejemplo {

	
	@Test public void prueba(){
		try{
			final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
			final TokenRequest tr = TokenRequest.builder()
					.usuario(props.getProperty("integrador.usuario"))
					.contrasena(props.getProperty("integrador.contrasena"))
					.build();
			final TokenResponse tokenresp = api.token().ejecuta(tr);	
			final EmisoresDocumentosRequest edr = EmisoresDocumentosRequest.builder()
				.token(tokenresp.getToken())
				.rfc("XAXX010101000")
				.pdf("HOLA")
				.idTipoDocumento(1)
				.build();
			final EmisoresDocumentosResponse respuesta = api.emisoresdocumentos().ejecuta(edr);
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error(Arrays.toString(ae.getErrores().toArray()),ae);
		}
	}
}
