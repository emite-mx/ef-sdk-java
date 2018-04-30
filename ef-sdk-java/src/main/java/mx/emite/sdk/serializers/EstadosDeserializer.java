package mx.emite.sdk.serializers;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import mx.emite.sdk.enums.sat.Estados12;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

public class EstadosDeserializer extends JsonDeserializer<Estados12>{

	
	@Override
	public Estados12 deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException,ApiException {
		final String estado = p.getText();
		if(StringUtils.isEmpty(estado))
			return null;
		final Estados12 e =  Estados12.busca(estado);
		if(e!=null)
			return e;
		throw new ApiException(I_Api_Errores.CLIENTE_REQUEST_INVALIDO,"El estado "+estado+" no se encuentra en el catálogo del SAT");
			
	}
	
}
