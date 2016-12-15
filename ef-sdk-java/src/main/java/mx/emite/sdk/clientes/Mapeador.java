package mx.emite.sdk.clientes;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
public class Mapeador extends ObjectMapper{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2070804639870254687L;

	public Mapeador(){
		enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		disable(SerializationFeature.INDENT_OUTPUT);
		disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		setDefaultPrettyPrinter(new DefaultPrettyPrinter());

	}

	public <T> T deserializa(String json, Class<T> clase) throws ApiException {
		try{
		return readValue(json, clase);
		}
		catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_DESERIALIZANDO,ex);
		}
	}
	
	public <T> T deserializa(final RespuestaHttp response, final Class<T> clazz) throws ApiException{
        if (response.isJson()) {
            return deserializa(response.getBody(), clazz);
        } else if (response.getBody() != null) {
            log.debug("La respuesta no es Json: {}", response.getBody());
        }
        return null;
    }

	public String serializa(Object objeto) throws ApiException{
		if(objeto==null)
			return "";
		try {
			final String json = writer().withDefaultPrettyPrinter().writeValueAsString(objeto);
			return json;
		} catch (JsonProcessingException e) {
			throw new ApiException(I_Api_Errores.PROXY_SERIALIZANDO,e);
		}
	}
	
	
}
