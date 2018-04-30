package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposIncapacidad12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposIncapacidadAdapter extends XmlAdapter<String,TiposIncapacidad12> implements TypeHandler{

	@Override
	public TiposIncapacidad12 unmarshal(String metodo) throws ApiException {
		return TiposIncapacidad12.unmarshall(metodo);
	}
	@Override
	public Class<TiposIncapacidad12> getType() {
		return TiposIncapacidad12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposIncapacidad12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposIncapacidad12)
			return TiposIncapacidad12.marshall((TiposIncapacidad12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposIncapacidad12 v) throws Exception {
		return TiposIncapacidad12.marshall(v);
	}

}
