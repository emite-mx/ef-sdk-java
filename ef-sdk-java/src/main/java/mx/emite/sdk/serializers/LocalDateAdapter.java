package mx.emite.sdk.serializers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;




public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

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
	}
