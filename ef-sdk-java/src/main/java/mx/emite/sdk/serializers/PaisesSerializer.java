package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.Paises;

public class PaisesSerializer extends JsonSerializer<Paises>{

	
	
	

	@Override
	public void serialize(Paises paise, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(paise==null||paise.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeString(paise.getIdSat());
	}
	
}
