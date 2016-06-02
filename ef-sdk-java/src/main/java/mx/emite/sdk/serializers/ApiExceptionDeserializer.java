package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import mx.emite.sdk.errores.ApiError;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

public class ApiExceptionDeserializer extends JsonDeserializer<ApiException>{

	

	
	@Override
	public ApiException deserialize(JsonParser p, DeserializationContext ctxt)	throws IOException, JsonProcessingException {
		final ApiError node = p.readValueAs(ApiError.class);
		try{
			return new ApiException(I_Api_Errores.getTipo(node.getCodigo()),node.getErrores());
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
