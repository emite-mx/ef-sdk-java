package mx.emite.sdk.serializers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FechaDeserializer extends JsonDeserializer<LocalDate>{

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy",new Locale("es","MX"));
	

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		final String fecha = p.getText();
		if(StringUtils.isEmpty(fecha))
			return null;
		try{
			return LocalDate.parse(fecha,df);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
	
}
