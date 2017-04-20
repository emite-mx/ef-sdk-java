package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.TiposImpuesto33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposImpuesto33Adapter extends XmlAdapter<String,TiposImpuesto33> implements TypeHandler{

	@Override
	public TiposImpuesto33 unmarshal(String metodo) throws ApiException {
		return TiposImpuesto33.unmarshall(metodo);
	}
	@Override
	public Class<TiposImpuesto33> getType() {
		return TiposImpuesto33.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposImpuesto33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposImpuesto33)
			return TiposImpuesto33.marshall((TiposImpuesto33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposImpuesto33 v) throws Exception {
		return TiposImpuesto33.marshall(v);
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
