package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.Bancos;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class BancosAdapter extends XmlAdapter<String,Bancos> implements TypeHandler{

	@Override
	public Bancos unmarshal(String metodo) throws ApiException {
		return Bancos.unmarshall(metodo);
	}
	@Override
	public Class<Bancos> getType() {
		return Bancos.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return Bancos.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof Bancos)
			return Bancos.marshall((Bancos)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(Bancos v) throws Exception {
		return Bancos.marshall(v);
	}
}
