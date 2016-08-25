package mx.emite.sdk.serializers;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.Getter;

public class MontoDeserializer extends JsonDeserializer<BigDecimal>{

	@Getter private final static int precision=30;
	@Getter private final static int escala=6;

	
	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)	throws IOException, JsonProcessingException {
		final String monto = p.getText();
		if(StringUtils.isEmpty(monto))
			return null;
		try{
			return new BigDecimal(monto).setScale(escala, BigDecimal.ROUND_HALF_UP);
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
