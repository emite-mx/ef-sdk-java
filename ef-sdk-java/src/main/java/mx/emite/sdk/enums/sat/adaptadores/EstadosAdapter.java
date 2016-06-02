package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class EstadosAdapter extends XmlAdapter<String,Estados> implements TypeHandler{

	@Override
	public Estados unmarshal(String metodo) throws ApiException {
		return Estados.unmarshall(metodo);
	}
	@Override
	public Class<Estados> getType() {
		return Estados.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Estados.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Estados)
			return Estados.marshall((Estados)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Estados v) throws Exception {
		return Estados.marshall(v);
	}
}
