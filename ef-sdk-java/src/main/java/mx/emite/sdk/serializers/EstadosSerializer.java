package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.Estados;

public class EstadosSerializer extends JsonSerializer<Estados>{

	
	
	

	@Override
	public void serialize(Estados estado, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(estado==null)
			gen.writeNull();
		gen.writeString(estado.getIdSat());
	}
	
}
