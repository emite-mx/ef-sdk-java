package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.cfdi33.RegimenesFiscales33;

public class RegimenesFiscales33Serializer extends JsonSerializer<RegimenesFiscales33>{

	
	
	

	@Override
	public void serialize(RegimenesFiscales33 regimen, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(regimen==null)
			gen.writeNull();
		else if(regimen.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeNumber(regimen.getIdSat());
	}
	
}
