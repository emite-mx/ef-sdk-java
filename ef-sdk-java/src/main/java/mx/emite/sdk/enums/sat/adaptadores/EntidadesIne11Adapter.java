package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.EntidadesIne11;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class EntidadesIne11Adapter extends XmlAdapter<String,EntidadesIne11> implements TypeHandler{

	@Override
	public EntidadesIne11 unmarshal(String metodo) throws ApiException {
		return EntidadesIne11.unmarshall(metodo);
	}
	@Override
	public Class<EntidadesIne11> getType() {
		return EntidadesIne11.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return EntidadesIne11.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof EntidadesIne11)
			return EntidadesIne11.marshall((EntidadesIne11)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(EntidadesIne11 v) throws Exception {
		return EntidadesIne11.marshall(v);
	}
}
