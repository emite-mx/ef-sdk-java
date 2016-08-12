package mx.emite.sdk.serializers;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;




public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

	private static final DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd'T'HH:mm:ss").parseLenient().appendOffset("+HH:MM", "Z").toFormatter();
			
		//	DateTimeFormatter.ofPattern(,new Locale("es","MX"));

	@Override
	public ZonedDateTime unmarshal(String date) throws Exception {
		if(StringUtils.isEmpty(date))
			return null;
		return ZonedDateTime.parse(date,df);
	}

	  @Override
	public String marshal(ZonedDateTime date) throws Exception {
		if(date==null)
			return null;
	    return date.format(df);
	  }

   public static DateTimeFormatter getZonaFormatter(){
	   return df;
   }
	  
	  
}
