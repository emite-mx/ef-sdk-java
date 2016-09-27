package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.PaisesRetencion;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class PaisesRetencionAdapter extends XmlAdapter<String,PaisesRetencion> implements TypeHandler{

	@Override
	public PaisesRetencion unmarshal(String metodo) throws ApiException {
		return PaisesRetencion.unmarshall(metodo);
	}
	@Override
	public Class<PaisesRetencion> getType() {
		return PaisesRetencion.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return PaisesRetencion.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof PaisesRetencion)
			return PaisesRetencion.marshall((PaisesRetencion)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(PaisesRetencion v) throws Exception {
		return PaisesRetencion.marshall(v);
	}
	
	
}
