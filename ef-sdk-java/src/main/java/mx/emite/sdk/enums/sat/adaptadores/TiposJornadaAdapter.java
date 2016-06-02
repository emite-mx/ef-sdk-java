package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposJornada;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposJornadaAdapter extends XmlAdapter<String,TiposJornada> implements TypeHandler{

	@Override
	public TiposJornada unmarshal(String metodo) throws ApiException {
		return TiposJornada.unmarshall(metodo);
	}
	@Override
	public Class<TiposJornada> getType() {
		return TiposJornada.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposJornada.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposJornada)
			return TiposJornada.marshall((TiposJornada)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposJornada v) throws Exception {
		return TiposJornada.marshall(v);
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
