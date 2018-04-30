package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposHoras12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposHorasAdapter extends XmlAdapter<String,TiposHoras12> implements TypeHandler{

	@Override
	public TiposHoras12 unmarshal(String metodo) throws ApiException {
		return TiposHoras12.unmarshall(metodo);
	}
	@Override
	public Class<TiposHoras12> getType() {
		return TiposHoras12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposHoras12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposHoras12)
			return TiposHoras12.marshall((TiposHoras12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposHoras12 v) throws Exception {
		return TiposHoras12.marshall(v);
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
