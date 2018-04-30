package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Estados12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class EstadosAdapter extends XmlAdapter<String,Estados12> implements TypeHandler{

	@Override
	public Estados12 unmarshal(String metodo) throws ApiException {
		return Estados12.unmarshall(metodo);
	}
	@Override
	public Class<Estados12> getType() {
		return Estados12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Estados12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Estados12)
			return Estados12.marshall((Estados12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Estados12 v) throws Exception {
		return Estados12.marshall(v);
	}
}
