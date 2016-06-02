package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposImpuesto;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposImpuestoAdapter extends XmlAdapter<String,TiposImpuesto> implements TypeHandler{

	@Override
	public TiposImpuesto unmarshal(String metodo) throws ApiException {
		return TiposImpuesto.unmarshall(metodo);
	}
	@Override
	public Class<TiposImpuesto> getType() {
		return TiposImpuesto.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposImpuesto.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposImpuesto)
			return TiposImpuesto.marshall((TiposImpuesto)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposImpuesto v) throws Exception {
		return TiposImpuesto.marshall(v);
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
