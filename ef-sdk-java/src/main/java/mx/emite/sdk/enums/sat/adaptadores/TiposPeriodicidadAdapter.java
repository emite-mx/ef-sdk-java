package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposPeriodicidad;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposPeriodicidadAdapter extends XmlAdapter<String,TiposPeriodicidad> implements TypeHandler{

	@Override
	public TiposPeriodicidad unmarshal(String metodo) throws ApiException {
		return TiposPeriodicidad.unmarshall(metodo);
	}
	@Override
	public Class<TiposPeriodicidad> getType() {
		return TiposPeriodicidad.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposPeriodicidad.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposPeriodicidad)
			return TiposPeriodicidad.marshall((TiposPeriodicidad)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposPeriodicidad v) throws Exception {
		return TiposPeriodicidad.marshall(v);
	}
	
	/*@Override
	public TiposImpuesto unmarshal(String metodo) throws ApiException {
		if(StringUtils.isEmpty(metodo))
			return null;
		return TiposImpuesto.busca(metodo);		
	}

	@Override
	public Class<?> getType() {
		return TiposImpuesto.class;
	}
*/
}
