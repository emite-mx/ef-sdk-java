package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposPeriodicidad12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposPeriodicidadAdapter extends XmlAdapter<String,TiposPeriodicidad12> implements TypeHandler{

	@Override
	public TiposPeriodicidad12 unmarshal(String metodo) throws ApiException {
		return TiposPeriodicidad12.unmarshall(metodo);
	}
	@Override
	public Class<TiposPeriodicidad12> getType() {
		return TiposPeriodicidad12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposPeriodicidad12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposPeriodicidad12)
			return TiposPeriodicidad12.marshall((TiposPeriodicidad12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposPeriodicidad12 v) throws Exception {
		return TiposPeriodicidad12.marshall(v);
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
