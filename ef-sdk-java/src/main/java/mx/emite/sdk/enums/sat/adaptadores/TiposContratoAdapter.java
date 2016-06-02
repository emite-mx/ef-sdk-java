package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposContrato;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposContratoAdapter extends XmlAdapter<String,TiposContrato> implements TypeHandler{

	@Override
	public TiposContrato unmarshal(String metodo) throws ApiException {
		return TiposContrato.unmarshall(metodo);
	}
	@Override
	public Class<TiposContrato> getType() {
		return TiposContrato.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposContrato.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposContrato)
			return TiposContrato.marshall((TiposContrato)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposContrato v) throws Exception {
		return TiposContrato.marshall(v);
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
