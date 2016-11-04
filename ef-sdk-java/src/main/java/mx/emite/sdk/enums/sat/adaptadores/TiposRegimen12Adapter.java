package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposRegimen12;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposRegimen12Adapter extends XmlAdapter<String,TiposRegimen12> implements TypeHandler{

	@Override
	public TiposRegimen12 unmarshal(String metodo) throws ApiException {
		return TiposRegimen12.unmarshall(metodo);
	}
	@Override
	public Class<TiposRegimen12> getType() {
		return TiposRegimen12.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposRegimen12.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposRegimen12)
			return TiposRegimen12.marshall((TiposRegimen12)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposRegimen12 v) throws Exception {
		return TiposRegimen12.marshall(v);
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
