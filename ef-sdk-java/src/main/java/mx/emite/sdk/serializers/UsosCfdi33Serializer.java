package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.cfdi33.UsosCfdi33;


public class UsosCfdi33Serializer extends JsonSerializer<UsosCfdi33>{

	
	
	

	@Override
	public void serialize(UsosCfdi33 fp, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(fp==null||fp.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeString(fp.getIdSat());
	}
	
}
