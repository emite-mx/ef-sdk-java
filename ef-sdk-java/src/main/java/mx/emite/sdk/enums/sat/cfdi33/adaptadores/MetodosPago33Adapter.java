package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.MetodosPago33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class MetodosPago33Adapter extends XmlAdapter<String,MetodosPago33> implements TypeHandler{

	@Override
	public MetodosPago33 unmarshal(String metodo) throws ApiException {
		return MetodosPago33.unmarshall(metodo);
	}
	@Override
	public Class<MetodosPago33> getType() {
		return MetodosPago33.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return MetodosPago33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof MetodosPago33) 
			return MetodosPago33.marshall((MetodosPago33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(MetodosPago33 v) throws Exception {
		return MetodosPago33.marshall(v);
	}
	
	
}
