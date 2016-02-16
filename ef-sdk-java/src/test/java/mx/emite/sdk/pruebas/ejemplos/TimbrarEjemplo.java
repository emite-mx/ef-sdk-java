package mx.emite.sdk.pruebas.ejemplos;

import org.junit.Test;

import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.proxy.request.TimbrarRequest;
import mx.emite.sdk.proxy.response.TimbrarResponse;

public class TimbrarEjemplo extends Ejemplo{

	@Override
	@Test
	public void prueba(){
		
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		
		final TimbrarRequest request = TimbrarRequest.builder()
				.usuario(props.getProperty("usuario"))
				.build();
		
		final TimbrarResponse respuesta = api.timbrador32().timbra(request);
		System.out.println(respuesta);	
	}
	
}
