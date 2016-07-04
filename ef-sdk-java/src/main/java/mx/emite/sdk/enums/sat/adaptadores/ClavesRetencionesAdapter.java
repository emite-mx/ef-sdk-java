package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.ClavesRetenciones;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class ClavesRetencionesAdapter extends XmlAdapter<String,ClavesRetenciones> implements TypeHandler{

	@Override
	public ClavesRetenciones unmarshal(String metodo) throws ApiException {
		return ClavesRetenciones.unmarshall(metodo);
	}
	@Override
	public Class<ClavesRetenciones> getType() {
		return ClavesRetenciones.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return ClavesRetenciones.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof ClavesRetenciones)
			return ClavesRetenciones.marshall((ClavesRetenciones)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(ClavesRetenciones v) throws Exception {
		return ClavesRetenciones.marshall(v);
	}
	
	
}
