package mx.emite.sdk.serializers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> implements TypeHandler{

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd",new Locale("es","MX"));

	@Override
	public LocalDate unmarshal(String date) throws Exception {
		if(StringUtils.isEmpty(date))
			return null;
		return LocalDate.parse(date,df);
	}

	  @Override
	public String marshal(LocalDate date) throws Exception {
		if(date==null)
			return null;
	    return df.format(date);
	  }

	@Override
	public Object parse(String text) throws TypeConversionException {
		try {
			return unmarshal(text);
		} catch (Exception e) {
			log.error("error unmarshalling "+text,e);
			return null;
		}
	}

	@Override
	public String format(Object value) {
		try {
			return marshal((LocalDate) value);
		} catch (Exception e) {
			log.error("error marshalling "+value.toString(),e);
			return null;
		}
	}

	@Override
	public Class<?> getType() {
		return LocalDate.class;
	}
	}
