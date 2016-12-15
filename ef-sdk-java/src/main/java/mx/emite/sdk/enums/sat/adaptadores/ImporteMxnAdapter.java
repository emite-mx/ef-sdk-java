package mx.emite.sdk.enums.sat.adaptadores;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;

@Slf4j
public class ImporteMxnAdapter extends XmlAdapter<String,BigDecimal> implements TypeHandler{

	static ThreadLocal<DecimalFormat> nf = new ThreadLocal<DecimalFormat>() {
	    @Override
	    public DecimalFormat initialValue() {
	    	final DecimalFormat df = new DecimalFormat();
	    	df.setMinimumFractionDigits(2);
	    	df.setMaximumFractionDigits(2);
	    	df.setGroupingUsed(false);
	        return df;
	    }
	};	
	
	@Override
	public BigDecimal unmarshal(String importe) throws ApiException {
		if(StringUtils.isEmpty(importe))
			return null;
		try{
			final BigDecimal res = new BigDecimal(importe);
			return res.setScale(2,RoundingMode.HALF_UP);
			
		}
		catch(Exception ex){
			throw new ApiException(I_Api_Errores.PROXY_DESERIALIZANDO,importe+" no es un importe valido",ex);
		}
	}
	@Override
	public Class<BigDecimal> getType() {
		return BigDecimal.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshal(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof BigDecimal)
			return marshal((BigDecimal)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(BigDecimal v) throws Exception {
		if(v==null)
			return null;
		return nf.get().format(v);
	}
	
	
}
