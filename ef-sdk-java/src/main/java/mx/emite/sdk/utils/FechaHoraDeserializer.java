package mx.emite.sdk.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FechaHoraDeserializer extends JsonDeserializer<LocalDateTime>{

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX"));

	
	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)	throws IOException, JsonProcessingException {
		final String fecha = p.getText();
		if(StringUtils.isEmpty(fecha))
			return null;
		try{
			return LocalDateTime.parse(fecha,df);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
