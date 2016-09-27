package mx.emite.sdk.serializers;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;




public class MontoAdapter extends XmlAdapter<String, BigDecimal> {

	

	@Override
	public BigDecimal unmarshal(String date) throws Exception {
		if(StringUtils.isEmpty(date))
			return null;
		BigDecimal r = 	new BigDecimal(date);
		r = r.setScale(6, RoundingMode.HALF_UP);			
		return r;
	}

	  @Override
	public String marshal(BigDecimal date) throws Exception {
		if(date==null)
			return null;
	    return date.toPlainString();
	  }
	}
