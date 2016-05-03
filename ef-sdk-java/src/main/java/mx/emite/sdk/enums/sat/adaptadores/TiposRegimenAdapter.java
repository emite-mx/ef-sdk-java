package mx.emite.sdk.enums.sat.adaptadores;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.enums.sat.TiposRegimen;
import mx.emite.sdk.errores.ApiException;

@Slf4j
public class TiposRegimenAdapter extends XmlAdapter<String,TiposRegimen> implements TypeHandler{

	@Override
	public TiposRegimen unmarshal(String metodo) throws ApiException {
		return TiposRegimen.unmarshall(metodo);
	}
	@Override
	public Class<TiposRegimen> getType() {
		return TiposRegimen.class;
	}
	@Override
	public Object parse(String text) throws TypeConversionException, ApiException {
		return TiposRegimen.parse(text);
	}



	@Override
	public String format(Object value){
		try{
		if(value instanceof TiposRegimen)
			return TiposRegimen.marshall((TiposRegimen)value);
		return null;
		}catch(Exception ex){
			log.error("error formateando",ex);
			return null;
		}
	}



	@Override
	public String marshal(TiposRegimen v) throws Exception {
		return TiposRegimen.marshall(v);
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
