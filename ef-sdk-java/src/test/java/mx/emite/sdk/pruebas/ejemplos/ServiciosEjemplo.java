package mx.emite.sdk.pruebas.ejemplos;

import org.junit.Test;

import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.proxy.response.ServiciosResponse;

public class ServiciosEjemplo extends Ejemplo {

	@Test
	public void prueba(){
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		ServiciosResponse respuesta = api.servicios().servicios();
		System.out.println(respuesta);	
	}
	
}
