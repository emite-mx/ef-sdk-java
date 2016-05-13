package mx.emite.sdk.serializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FechaHoraSerializer extends JsonSerializer<LocalDateTime>{

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX"));
	
	

	@Override
	public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(date==null)
			gen.writeNull();
		gen.writeString(df.format(date));
	}
	
}
