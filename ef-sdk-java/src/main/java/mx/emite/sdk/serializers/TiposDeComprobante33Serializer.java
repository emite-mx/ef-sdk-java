package mx.emite.sdk.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.emite.sdk.enums.sat.cfdi33.TiposDeComprobante33;

public class TiposDeComprobante33Serializer extends JsonSerializer<TiposDeComprobante33>{

	@Override
	public void serialize(TiposDeComprobante33 estado, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(estado==null||estado.getIdSat()==null)
			gen.writeNull();
		else
			gen.writeString(estado.getIdSat());
	}
	
}
