package mx.emite.sdk.pruebas.ejemplos.integradores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.IntegradorAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.request.SucursalesNombreRequest;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.response.SucursalesNombreResponse;
import mx.emite.sdk.scot.response.TokenResponse;

@Slf4j
public class SucursalesNombreEjemplo extends Ejemplo {

	
	@Test public void prueba(){
		try{
			final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
			final TokenRequest tr = TokenRequest.builder()
					.usuario(props.getProperty("integrador.usuario"))
					.contrasena(props.getProperty("integrador.contrasena"))
					.build();
			final TokenResponse tokenresp = api.token().ejecuta(tr);	
			final SucursalesNombreRequest timbresreq = SucursalesNombreRequest.builder()
				.token(tokenresp.getToken())
				.rfc("XAXX010101000")
				.nombreAnterior("sucursal")
				.nombreNuevo("sucursal 2")
				.build();
			final SucursalesNombreResponse respuesta = api.sucursalesnombre().ejecuta(timbresreq);
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
}
