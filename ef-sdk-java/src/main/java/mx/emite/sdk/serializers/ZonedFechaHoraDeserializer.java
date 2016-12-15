package mx.emite.sdk.serializers;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZonedFechaHoraDeserializer extends JsonDeserializer<ZonedDateTime>{

	private static final DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd'T'HH:mm:ss").parseLenient().appendOffset("+HH:MM", "Z").toFormatter();
	
	
	@Override
	public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String fecha = p.getText();
		if(StringUtils.isEmpty(fecha))
			return null;
		try{
			return ZonedDateTime.parse(fecha,df);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
