package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposIncapacidad;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposIncapacidadAdapter extends XmlAdapter<String,TiposIncapacidad> implements TypeHandler{

	@Override
	public TiposIncapacidad unmarshal(String metodo) throws ApiException {
		return TiposIncapacidad.unmarshall(metodo);
	}
	@Override
	public Class<TiposIncapacidad> getType() {
		return TiposIncapacidad.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposIncapacidad.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposIncapacidad)
			return TiposIncapacidad.marshall((TiposIncapacidad)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposIncapacidad v) throws Exception {
		return TiposIncapacidad.marshall(v);
	}

}
