package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.FormasPago;

@Deprecated
public class FormasPagoSerializer extends JsonSerializer<FormasPago>{

	
	
	

	@Override
	public void serialize(FormasPago fp, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(fp==null||fp.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeNumber(fp.getIdSat());
	}
	
}
