package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposContrato12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposContrato12Adapter extends XmlAdapter<String,TiposContrato12> implements TypeHandler{

	@Override
	public TiposContrato12 unmarshal(String metodo) throws ApiException {
		return TiposContrato12.unmarshall(metodo);
	}
	@Override
	public Class<TiposContrato12> getType() {
		return TiposContrato12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposContrato12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposContrato12)
			return TiposContrato12.marshall((TiposContrato12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposContrato12 v) throws Exception {
		return TiposContrato12.marshall(v);
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
