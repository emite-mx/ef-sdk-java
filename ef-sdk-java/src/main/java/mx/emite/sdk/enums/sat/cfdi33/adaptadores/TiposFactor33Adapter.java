package mx.emite.sdk.enums.sat.cfdi33.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.cfdi33.TiposFactor33;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposFactor33Adapter extends XmlAdapter<String,TiposFactor33> implements TypeHandler{

	@Override
	public TiposFactor33 unmarshal(String metodo) throws ApiException {
		return TiposFactor33.unmarshall(metodo);
	}
	@Override
	public Class<TiposFactor33> getType() {
		return TiposFactor33.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposFactor33.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposFactor33)
			return TiposFactor33.marshall((TiposFactor33)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposFactor33 v) throws Exception {
		return TiposFactor33.marshall(v);
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
