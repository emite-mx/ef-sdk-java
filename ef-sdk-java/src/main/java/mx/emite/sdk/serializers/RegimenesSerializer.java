package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.RegimenesFiscales;

public class RegimenesSerializer extends JsonSerializer<RegimenesFiscales>{

	
	
	

	@Override
	public void serialize(RegimenesFiscales regimen, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(regimen==null)
			gen.writeNull();
		else if(regimen.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeNumber(regimen.getIdSat());
	}
	
}
