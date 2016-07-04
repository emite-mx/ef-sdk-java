package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TipoContribuyenteSujetoRetencion;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TipoContribuyenteSujetoRetencionAdapter extends XmlAdapter<String,TipoContribuyenteSujetoRetencion> implements TypeHandler{

	@Override
	public TipoContribuyenteSujetoRetencion unmarshal(String metodo) throws ApiException {
		return TipoContribuyenteSujetoRetencion.unmarshall(metodo);
	}
	@Override
	public Class<TipoContribuyenteSujetoRetencion> getType() {
		return TipoContribuyenteSujetoRetencion.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TipoContribuyenteSujetoRetencion.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TipoContribuyenteSujetoRetencion)
			return TipoContribuyenteSujetoRetencion.marshall((TipoContribuyenteSujetoRetencion)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TipoContribuyenteSujetoRetencion v) throws Exception {
		return TipoContribuyenteSujetoRetencion.marshall(v);
	}
	
	
}
