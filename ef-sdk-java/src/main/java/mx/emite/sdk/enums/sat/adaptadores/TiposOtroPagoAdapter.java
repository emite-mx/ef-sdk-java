package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposOtroPago12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposOtroPagoAdapter extends XmlAdapter<String,TiposOtroPago12> implements TypeHandler{

	@Override
	public TiposOtroPago12 unmarshal(String metodo) throws ApiException {
		return TiposOtroPago12.unmarshall(metodo);
	}
	@Override
	public Class<TiposOtroPago12> getType() {
		return TiposOtroPago12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposOtroPago12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposOtroPago12)
			return TiposOtroPago12.marshall((TiposOtroPago12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposOtroPago12 v) throws Exception {
		return TiposOtroPago12.marshall(v);
	}

}
