package mx.emite.sdk.serializers;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ZonedFechaHoraSerializer extends JsonSerializer<ZonedDateTime>{

	private static final DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd'T'HH:mm:ss").parseLenient().appendOffset("+HH:MM", "Z").toFormatter();
	
	@Override
	public void serialize(ZonedDateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(date==null)
			gen.writeNull();
		gen.writeString(df.format(date));
	}
	
}
