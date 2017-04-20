package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.TiposRelacion33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposRelacion33Adapter extends XmlAdapter<String,TiposRelacion33> implements TypeHandler{

	@Override
	public TiposRelacion33 unmarshal(String metodo) throws ApiException {
		return TiposRelacion33.unmarshall(metodo);
	}
	@Override
	public Class<TiposRelacion33> getType() {
		return TiposRelacion33.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposRelacion33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposRelacion33)
			return TiposRelacion33.marshall((TiposRelacion33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposRelacion33 v) throws Exception {
		return TiposRelacion33.marshall(v);
	}
	
	 
}
