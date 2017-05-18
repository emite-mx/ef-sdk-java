package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.TiposCadenaPago33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposCadenaPago33Adapter extends XmlAdapter<String,TiposCadenaPago33> implements TypeHandler{

	@Override
	public TiposCadenaPago33 unmarshal(String metodo) throws ApiException {
		return TiposCadenaPago33.unmarshall(metodo);
	}
	@Override
	public Class<TiposCadenaPago33> getType() {
		return TiposCadenaPago33.class;
	}
	
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposCadenaPago33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposCadenaPago33)
			return TiposCadenaPago33.marshall((TiposCadenaPago33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposCadenaPago33 v) throws Exception {
		return TiposCadenaPago33.marshall(v);
	}
	
	
}
