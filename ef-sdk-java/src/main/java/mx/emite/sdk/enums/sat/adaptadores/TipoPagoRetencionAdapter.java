package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoPagoRetencion;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoPagoRetencionAdapter extends XmlAdapter<String,TipoPagoRetencion> implements TypeHandler{

	@Override
	public TipoPagoRetencion unmarshal(String metodo) throws ApiException {
		return TipoPagoRetencion.unmarshall(metodo);
	}
	@Override
	public Class<TipoPagoRetencion> getType() {
		return TipoPagoRetencion.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoPagoRetencion.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoPagoRetencion)
			return TipoPagoRetencion.marshall((TipoPagoRetencion)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoPagoRetencion v) throws Exception {
		return TipoPagoRetencion.marshall(v);
	}
	
	

}
