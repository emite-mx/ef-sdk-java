package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposHoras;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposHorasAdapter extends XmlAdapter<String,TiposHoras> implements TypeHandler{

	@Override
	public TiposHoras unmarshal(String metodo) throws ApiException {
		return TiposHoras.unmarshall(metodo);
	}
	@Override
	public Class<TiposHoras> getType() {
		return TiposHoras.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposHoras.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposHoras)
			return TiposHoras.marshall((TiposHoras)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposHoras v) throws Exception {
		return TiposHoras.marshall(v);
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
