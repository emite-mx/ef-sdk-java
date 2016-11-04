package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposOtroPago;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposOtroPagoAdapter extends XmlAdapter<String,TiposOtroPago> implements TypeHandler{

	@Override
	public TiposOtroPago unmarshal(String metodo) throws ApiException {
		return TiposOtroPago.unmarshall(metodo);
	}
	@Override
	public Class<TiposOtroPago> getType() {
		return TiposOtroPago.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposOtroPago.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposOtroPago)
			return TiposOtroPago.marshall((TiposOtroPago)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposOtroPago v) throws Exception {
		return TiposOtroPago.marshall(v);
	}

}
