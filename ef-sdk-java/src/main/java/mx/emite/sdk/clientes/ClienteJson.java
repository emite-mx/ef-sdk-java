package mx.emite.sdk.clientes;

import java.util.Collections;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
@Getter
public class ClienteJson {

	private final Ambiente ambiente;
	private final ClienteHttp http;
	private final Mapeador mapeador = new Mapeador();
	
	public ClienteJson(final Ambiente ambiente){
		this.ambiente=ambiente;
		this.http=new ClienteHttp();
		log.debug("cliente emite creado "+ambiente.name());
	}
	
	public <T> T get(final String ruta, final Class<T> clazz) throws ApiException{
		final RespuestaHttp response = http.get(ruta);
		this.errores(response);
		return mapeador.deserializa(response, clazz);
	}
	
	public <T> T post(final String ruta,Object objeto, final Class<T> clazz) throws ApiException{
		final RespuestaHttp response = http.post(ruta,mapeador.serializa(objeto));
		this.errores(response);
		return mapeador.deserializa(response, clazz);
	}
	
	
	
	private void errores(final RespuestaHttp response) throws ApiException {
        if (response.getStatusCode() >= 300) {
            if (response.isJson()) {
                ApiException error = mapeador.deserializa(response.getBody(),ApiException.class);
                error.setMensajes(Collections.singletonList(response.getBody()));
                throw error;
            } else {
                log.error("La respuesta no es Json. Code: {}, body: {} ", response.getStatusCode(), response.getBody());
                ApiException error = new ApiException(I_Api_Errores.PROXY_PROCESANDO_RESPUESTA,
                		"["
                        + response.getStatusCode() + "] Internal server error");
                error.setMensajes(Collections.singletonList(response.getBody()));
                
                throw error;
            }
        }
    }

	
	
}
