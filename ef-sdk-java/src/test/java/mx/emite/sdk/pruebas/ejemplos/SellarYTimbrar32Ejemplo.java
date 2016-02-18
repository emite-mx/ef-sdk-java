package mx.emite.sdk.pruebas.ejemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.EmiteAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.proxy.request.SellarYTimbrarRequest;
import mx.emite.sdk.proxy.response.SellarYTimbrarResponse;

@Slf4j
public class SellarYTimbrar32Ejemplo extends Ejemplo{

	
	/*@Test*/
	public void pruebaXmlBase64(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		
		final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.xml(props.getProperty("xml.base64"))
				.build();
		
		final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
		procesaRespuesta(respuesta);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}catch(ApiException ex){
			log.error("error sellando",ex);
		}
	}
	
	//@Test
	public void pruebaXmlSinCodificar(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		
		final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.codifica(props.getProperty("xml.sincodificar"))
				.build()				
				;
		
		final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
		procesaRespuesta(respuesta);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
	}
	
	//@Test
	public void pruebaXmlEnArchivo(){
			try{
			final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
			
			final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
					.usuario(props.getProperty("emisor.usuario"))
					.contrasena(props.getProperty("emisor.contrasena"))
					.archivo(props.getProperty("xml.ruta"))
					.build()
					
					; 
			
			final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
			procesaRespuesta(respuesta);
			log.debug(respuesta.toString());
			log.debug(respuesta.getXmlDecodificado());
			}catch(ApiException ex){
				log.error(Arrays.toString(ex.getErrores().toArray()),ex);
			}
	}
	
	@Test
	public void pruebaXmlEnInputStream(){
		try{
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		
		final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.is(new FileInputStream(props.getProperty("xml.ruta")))
				.build()
				
				; 
		
		final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
		procesaRespuesta(respuesta);
		log.debug(respuesta.toString());
		log.debug(respuesta.getXmlDecodificado());
		}
		catch(FileNotFoundException io){
			log.error("archivo no encontrado",io);
		}
		catch(ApiException ex){
			log.error(Arrays.toString(ex.getErrores().toArray()),ex);
		}
}
}
