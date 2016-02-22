package mx.emite.sdk.serializers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;




public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",new Locale("es","MX"));

	@Override
	public LocalDateTime unmarshal(String date) throws Exception {
		if(StringUtils.isEmpty(date))
			return null;
		return LocalDateTime.parse(date,df);
	}

	  @Override
	public String marshal(LocalDateTime date) throws Exception {
		if(date==null)
			return null;
	    return df.format(date);
	  }
	}
