package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.FormasPago33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class FormasPago33Adapter extends XmlAdapter<String,FormasPago33> implements TypeHandler{

	@Override
	public FormasPago33 unmarshal(String metodo) throws ApiException {
		return FormasPago33.unmarshall(metodo);
	}
	@Override
	public Class<FormasPago33> getType() {
		return FormasPago33.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return FormasPago33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof FormasPago33)
			return FormasPago33.marshall((FormasPago33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(FormasPago33 v) throws Exception {
		return FormasPago33.marshall(v);
	}
	
	
}
