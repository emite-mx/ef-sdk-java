package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposRiesgo;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposRiesgoAdapter extends XmlAdapter<String,TiposRiesgo> implements TypeHandler{

	@Override
	public TiposRiesgo unmarshal(String metodo) throws ApiException {
		return TiposRiesgo.unmarshall(metodo);
	}
	@Override
	public Class<TiposRiesgo> getType() {
		return TiposRiesgo.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposRiesgo.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposRiesgo)
			return TiposRiesgo.marshall((TiposRiesgo)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposRiesgo v) throws Exception {
		return TiposRiesgo.marshall(v);
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
