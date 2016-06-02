package mx.emite.sdk.serializers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FechaSerializer extends JsonSerializer<LocalDate>{

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy",new Locale("es","MX"));
	
	

	@Override
	public void serialize(LocalDate date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(date==null)
			gen.writeNull();
		gen.writeString(df.format(date));
	}
	
}
