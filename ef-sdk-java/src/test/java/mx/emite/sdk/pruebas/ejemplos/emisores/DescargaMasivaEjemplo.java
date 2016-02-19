package mx.emite.sdk.pruebas.ejemplos.emisores;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.ZipRequest;
import mx.emite.sdk.proxy.request.extra.ConsultaFiltro;
import mx.emite.sdk.proxy.response.ZipResponse;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;

@Slf4j
public class DescargaMasivaEjemplo extends Ejemplo{

	@Test
	public void pruebaDescarga(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final ZipRequest request = ZipRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.xml(true)
				.filtro(ConsultaFiltro.builder()
						.rango(LocalDate.of(2016, 01, 01), LocalDate.of(2016, 01, 31))
						.build())
				.build()
				; 		
		final ZipResponse respuesta = api.descargamasiva().ejecuta(request);
		log.debug(respuesta.toString());
		respuesta.guardaZip(props.getProperty("zip.ruta"));
		
		}		
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
}
